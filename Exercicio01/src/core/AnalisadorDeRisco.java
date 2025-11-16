package core;
import strategy.EstrategiaRisco;

public class AnalisadorDeRisco {
    private EstrategiaRisco estrategia;

    // Permite trocar estratégia em tempo real ou tempo de exe
    public void setEstrategia(EstrategiaRisco estrategia) {
        this.estrategia = estrategia;
    }

    public void executarAnalise(ContextoFinanceiro contexto) {
        if (estrategia == null) {
            System.out.println("Erro: Nenhuma estratégia definida!");
            return;
        }

        double risco = estrategia.calcular(contexto);
        System.out.println("Algoritmo: " + estrategia.getNome());
        System.out.println("Risco Calculado: R$ " + String.format("%.2f", risco));
        System.out.println();
    }
}
