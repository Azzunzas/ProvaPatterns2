package strategy;

import core.ContextoFinanceiro;

public class StressTesting implements EstrategiaRisco{
    @Override
    public double calcular(ContextoFinanceiro ctx) {
        // Cálculo dummy: Perda de 40% em cenário extremo
        return ctx.getValorPortfolio() * 0.40;
    }

    @Override
    public String getNome() {
        return "Stress Testing (Cenário Extremo)";
    }
}
