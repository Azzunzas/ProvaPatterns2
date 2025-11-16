import core.AnalisadorDeRisco;
import core.ContextoFinanceiro;
import strategy.ExpectedShortfall;
import strategy.StressTesting;
import strategy.ValueAtRisk;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ANÁLISE DE RISCO ===\n");

        // Contexto financeiro
        ContextoFinanceiro contexto = new ContextoFinanceiro(
                1_000_000.0,  // valor
                0.20,               // % de volatilidade
                21                  // Dias
        );

        AnalisadorDeRisco analisador = new AnalisadorDeRisco();

        // Value at Risk
        System.out.println("[1] Usando Value at Risk:");
        analisador.setEstrategia(new ValueAtRisk());
        analisador.executarAnalise(contexto);

        //  Expected Shortfall (troca dinâmica)
        System.out.println("[2] Mudando para Expected Shortfall:");
        analisador.setEstrategia(new ExpectedShortfall());
        analisador.executarAnalise(contexto);

        //  Stress Testing (troca dinâmica)
        System.out.println("[3] Mudando para Stress Testing:");
        analisador.setEstrategia(new StressTesting());
        analisador.executarAnalise(contexto);

        //  Troca baseada em condição
        System.out.println("[4] Escolha dinâmica baseada em volatilidade:");
        if (contexto.getVolatilidade() > 0.15) {
            System.out.println("Alta volatilidade detectada! Usando análise conservadora...");
            analisador.setEstrategia(new ExpectedShortfall());
        } else {
            analisador.setEstrategia(new ValueAtRisk());
        }
        analisador.executarAnalise(contexto);
    }
}
