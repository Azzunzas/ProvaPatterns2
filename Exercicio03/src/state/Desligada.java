package state;

import context.Usina;

public class Desligada implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        u.setTemperatura(u.getTemperatura() + graus);
        System.out.println("Aquecendo... " + u.getTemperatura() + "°C");
        if (u.getTemperatura() > 150) {
            u.setEstado(new OperacaoNormal());
        }
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        System.out.println(" Já está desligada");
    }

    @Override
    public void falhaResfriamento(Usina u) {
        System.out.println(" Não é crítico quando desligada");
    }

    @Override
    public String getNome() { return "DESLIGADA"; }
}
