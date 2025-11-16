package target;

public interface ProcessadorDeTransacoes {
    boolean autorizar(String cartao, double valor, String moeda);
}
