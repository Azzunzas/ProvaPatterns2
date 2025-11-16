package state;

import context.Usina;

public class AlertaVermelho implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() + graus);
        System.out.println("Temperatura: " + u.getTemperatura() + "°C");
        System.out.println("MÁXIMA PRIORIDADE!");
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() - graus);
        System.out.println("Temperatura: " + u.getTemperatura() + "°C");

        if (u.getTemperatura() < 400) {
            System.out.println("Melhorando, mas ainda em alerta");
            u.setEstado(new AlertaAmarelo());
        }
    }

    @Override
    public void falhaResfriamento(Usina u) {
        // REGRA: Só pode ir para EMERGÊNCIA via ALERTA VERMELHO
        System.out.println("CATASTRÓFICO: Falha total!");
        u.setResfriamentoAtivo(false);
        u.setEstado(new Emergencia());
    }

    @Override
    public String getNome() { return "ALERTA VERMELHO"; }
}
