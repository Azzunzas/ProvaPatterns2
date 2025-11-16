package context;

import handler.*;
import model.NotaFiscal;

public class SistemaValidacaoNFe {
    private Validador primeiroValidador;

    public void configurarCadeia(boolean[] forcaErros) {
        // Monta a cadeia: v1 -> v2 -> v3 -> v4 -> v5
        Validador v1 = new ValidadorSchema(forcaErros[0]);
        Validador v2 = new ValidadorCertificado(forcaErros[1]);
        Validador v3 = new ValidadorRegrasFiscais(forcaErros[2]);
        Validador v4 = new ValidadorBancoDados(forcaErros[3]);
        Validador v5 = new ValidadorSEFAZ(forcaErros[4]);

        v1.setProximo(v2);
        v2.setProximo(v3);
        v3.setProximo(v4);
        v4.setProximo(v5);

        primeiroValidador = v1;
    }

    public boolean validar(NotaFiscal nf) {
        System.out.println("\nIniciando validacao da NF-e: " + nf.getNumero());
        System.out.println("=".repeat(50));

        ContextoValidacao contexto = new ContextoValidacao();
        primeiroValidador.validar(nf, contexto);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Resultado: " + contexto.getFalhas() + " falha(s)");

        // Se houve falhas, executa rollback
        if (contexto.getFalhas() > 0) {
            contexto.executarRollback(nf);
        }

        boolean sucesso = contexto.getFalhas() == 0;
        System.out.println(sucesso ? "Status Final: VALIDA" : "Status Final: INVALIDA");

        return sucesso;
    }
}
