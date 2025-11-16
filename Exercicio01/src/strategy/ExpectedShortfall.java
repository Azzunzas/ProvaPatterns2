package strategy;

import core.ContextoFinanceiro;

public class ExpectedShortfall implements EstrategiaRisco{
    @Override
    public double calcular(ContextoFinanceiro ctx) {
        // Cálculo dummy: ES = VaR * 1.3 (mais conservador)
        double var = ctx.getValorPortfolio() * ctx.getVolatilidade() * 1.65;
        return var * 1.3;
    }

    @Override
    public String getNome() {
        return "Expected Shortfall ";
    }
}
