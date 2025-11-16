package state;

import context.Usina;

public class Emergencia implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() + graus);
        System.out.println("EMERGÊNCIA: " + u.getTemperatura() + "°C");
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() - graus);
        System.out.println("Tentando resfriar: " + u.getTemperatura() + "°C");

        if (u.getTemperatura() < 350 && u.isResfriamentoAtivo()) {
            System.out.println("Estabilizando... Voltando para vermelho");
            u.setEstado(new AlertaVermelho());
        }
    }

    @Override
    public void falhaResfriamento(Usina u) {
        System.out.println("Já está em falha total");
    }

    @Override
    public String getNome() { return "!!! EMERGÊNCIA !!!"; }
}
