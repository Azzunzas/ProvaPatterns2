package handler;

import context.ContextoValidacao;
import model.NotaFiscal;
import model.ResultadoValidacao;

public abstract class Validador {
    protected Validador proximo;
    protected int timeoutSegundos;
    protected boolean executarApenasSeAnterioresPassarem;

    public Validador(int timeout, boolean condicional) {
        this.timeoutSegundos = timeout;
        this.executarApenasSeAnterioresPassarem = condicional;
    }

    public void setProximo(Validador validador) {
        this.proximo = validador;
    }

    public abstract String getNome();
    protected abstract ResultadoValidacao validarInterno(NotaFiscal nf);

    // Método para rollback (dummy - só implementado por quem modifica dados)
    public void rollback(NotaFiscal nf) {
        // Por padrão, não faz nada
    }

    public ResultadoValidacao validar(NotaFiscal nf, ContextoValidacao contexto) {
        // Circuit breaker: interrompe após 3 falhas
        if (contexto.getFalhas() >= 3) {
            System.out.println("Circuit Breaker: Cadeia interrompida apos 3 falhas");
            return new ResultadoValidacao(false, "Circuit breaker ativado");
        }

        // Validação condicional: pula se anteriores falharam
        if (executarApenasSeAnterioresPassarem && contexto.getFalhas() > 0) {
            System.out.println(getNome() + ": Pulado (validador anterior falhou)");
            if (proximo != null) {
                return proximo.validar(nf, contexto);
            }
            return new ResultadoValidacao(true, "Pulado");
        }

        System.out.println("\nExecutando: " + getNome() + " (timeout: " + timeoutSegundos + "s)");

        // Simula timeout
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Executa validação
        ResultadoValidacao resultado = validarInterno(nf);

        if (resultado.isSucesso()) {
            System.out.println("Status: PASSOU - " + resultado.getMensagem());
            contexto.registrarValidador(this); // Registra para possível rollback
        } else {
            System.out.println("Status: FALHOU - " + resultado.getMensagem());
            contexto.incrementarFalhas();
        }

        // Passa para próximo validador na cadeia
        if (proximo != null) {
            return proximo.validar(nf, contexto);
        }

        return resultado;
    }
}
