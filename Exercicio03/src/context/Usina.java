package context;

import state.Desligada;
import state.EstadoUsina;
import state.Manutencao;

public class Usina {
    private EstadoUsina estado;
    private double temperatura;
    private boolean resfriamentoAtivo;
    private long tempoAcimaLimite; // em segundos (simulado)
    private EstadoUsina estadoAntesManutenção;

    public Usina() {
        this.temperatura = 100;
        this.resfriamentoAtivo = true;
        this.tempoAcimaLimite = 0;
        this.estado = new Desligada();
        System.out.println(" context.Usina iniciada: " + estado.getNome());
    }

    public void setEstado(EstadoUsina novo) {
        System.out.println(" TRANSIÇÃO: " + estado.getNome() + " → " + novo.getNome());
        this.estado = novo;
    }

    public EstadoUsina getEstado() { return estado; }
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temp) { this.temperatura = temp; }
    public boolean isResfriamentoAtivo() { return resfriamentoAtivo; }
    public void setResfriamentoAtivo(boolean ativo) { this.resfriamentoAtivo = ativo; }
    public long getTempoAcimaLimite() { return tempoAcimaLimite; }
    public void setTempoAcimaLimite(long tempo) { this.tempoAcimaLimite = tempo; }

    // Modo manutenção (sobrescreve estados normais)
    public void ativarManutenção() {
        if (!(estado instanceof Manutencao)) {
            estadoAntesManutenção = estado;
            setEstado(new Manutencao());
        }
    }

    public void desativarManutenção() {
        if (estado instanceof Manutencao && estadoAntesManutenção != null) {
            setEstado(estadoAntesManutenção);
            estadoAntesManutenção = null;
        }
    }

    // Delegação para estado atual
    public void aumentarTemp(double graus) { estado.aumentarTemp(this, graus); }
    public void diminuirTemp(double graus) { estado.diminuirTemp(this, graus); }
    public void falhaResfriamento() { estado.falhaResfriamento(this); }

    public void exibirStatus() {
        System.out.println("\n STATUS:");
        System.out.println("  Estado: " + estado.getNome());
        System.out.println("  Temperatura: " + String.format("%.1f°C", temperatura));
        System.out.println("  Resfriamento: " + (resfriamentoAtivo ? "OK" : "FALHOU"));
    }
}
