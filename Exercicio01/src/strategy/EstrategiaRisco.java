package strategy;

import core.ContextoFinanceiro;

public interface EstrategiaRisco {
    double calcular(ContextoFinanceiro contexto);
    String getNome();

}
