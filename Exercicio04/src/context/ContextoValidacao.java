package context;

import handler.Validador;
import model.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class ContextoValidacao {
    private int falhas;
    private List<Validador> validadoresExecutados;

    public ContextoValidacao() {
        this.falhas = 0;
        this.validadoresExecutados = new ArrayList<>();
    }

    public int getFalhas() { return falhas; }
    public void incrementarFalhas() { falhas++; }

    public void registrarValidador(Validador validador) {
        validadoresExecutados.add(validador);
    }

    // Rollback: chama método de rollback dos validadores na ordem reversa
    public void executarRollback(NotaFiscal nf) {
        if (validadoresExecutados.isEmpty()) return;

        System.out.println("\nROLLBACK: Desfazendo operacoes");
        for (int i = validadoresExecutados.size() - 1; i >= 0; i--) {
            validadoresExecutados.get(i).rollback(nf);
        }
    }
}
