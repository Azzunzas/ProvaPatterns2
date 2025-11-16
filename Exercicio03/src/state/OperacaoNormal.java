package state;

import context.Usina;

public class OperacaoNormal implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() + graus);
        System.out.println("Temperatura: " + u.getTemperatura() + "°C");

        // REGRA: > 300°C → ALERTA AMARELO
        if (u.getTemperatura() > 300) {
            System.out.println("Temperatura crítica!");
            u.setEstado(new AlertaAmarelo());
        }
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() - graus);
        System.out.println("Temperatura: " + u.getTemperatura() + "°C");
        if (u.getTemperatura() < 150) {
            u.setEstado(new Desligada());
        }
    }

    @Override
    public void falhaResfriamento(Usina u) {
        System.out.println("FALHA no resfriamento!");
        u.setResfriamentoAtivo(false);
        u.setEstado(new AlertaAmarelo());
    }

    @Override
    public String getNome() { return "OPERAÇÃO NORMAL"; }
}
