package core;

public class ContextoFinanceiro {
    private double valorPortfolio;
    private double volatilidade;
    private int diasHorizonte;

    public ContextoFinanceiro(double valor, double volatilidade, int dias) {
        this.valorPortfolio = valor;
        this.volatilidade = volatilidade;
        this.diasHorizonte = dias;
    }

    public double getValorPortfolio() { return valorPortfolio; }
    public double getVolatilidade() { return volatilidade; }
    public int getDiasHorizonte() { return diasHorizonte; }
}
