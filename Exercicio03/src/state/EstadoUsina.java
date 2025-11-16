package state;

import context.Usina;

public interface EstadoUsina {
    void aumentarTemp(Usina usina, double graus);
    void diminuirTemp(Usina usina, double graus);
    void falhaResfriamento(Usina usina);
    String getNome();
}
