package state;

import context.Usina;

public class AlertaAmarelo implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() + graus);
        System.out.println(" Temperatura: " + u.getTemperatura() + "°C");

        // REGRA: > 400°C por 30s → ALERTA VERMELHO
        if (u.getTemperatura() > 400) {
            u.setTempoAcimaLimite(u.getTempoAcimaLimite() + 10); // Simula tempo
            System.out.println(" Tempo acima do limite: " + u.getTempoAcimaLimite() + "s");

            if (u.getTempoAcimaLimite() >= 30) {
                System.out.println("CRÍTICO: Temperatura alta por muito tempo!");
                u.setEstado(new AlertaVermelho());
            }
        }
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() - graus);
        System.out.println("Temperatura: " + u.getTemperatura() + "°C");

        // Transição bidirecional
        if (u.getTemperatura() < 300 && u.isResfriamentoAtivo()) {
            System.out.println("(v) Normalizado");
            u.setTempoAcimaLimite(0);
            u.setEstado(new OperacaoNormal());
        }
    }

    @Override
    public void falhaResfriamento(Usina u) {
        System.out.println("Resfriamento falhou em alerta!");
        u.setResfriamentoAtivo(false);
        u.setEstado(new AlertaVermelho());
    }

    @Override
    public String getNome() { return "ALERTA AMARELO"; }
}
