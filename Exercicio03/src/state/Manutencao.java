package state;

import context.Usina;

public class Manutencao implements EstadoUsina{
    @Override
    public void aumentarTemp(Usina u, double graus) {
        System.out.println(" Modo manutenção: operações desabilitadas");
    }

    @Override
    public void diminuirTemp(Usina u, double graus) {
        System.out.println(" Modo manutenção: operações desabilitadas");
    }

    @Override
    public void falhaResfriamento(Usina u) {
        System.out.println(" Modo manutenção: testes permitidos");
    }

    @Override
    public String getNome() { return "MANUTENÇÃO"; }
}
