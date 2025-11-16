package strategy;

import core.ContextoFinanceiro;

public class ValueAtRisk implements EstrategiaRisco{
    @Override
    public double calcular(ContextoFinanceiro ctx) {
        // Cálculo dummy: VaR = Portfolio * Volatilidade * 1.65
        return ctx.getValorPortfolio() * ctx.getVolatilidade() * 1.65;
    }

    @Override
    public String getNome() {
        return "Value at Risk (V.R 95%)";
    }
}
