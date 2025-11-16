import adapter.AdapterBanco;
import legacy.SistemaBancoLegado;
import target.ProcessadorDeTransacoes;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PROCESSAMENTO DE TRANSAÇÕES ===\n");

        //  legado
        SistemaBancoLegado legado = new SistemaBancoLegado();

        //  (código banco = "001")
        ProcessadorDeTransacoes processador = new AdapterBanco(legado, "001");

        //  Transação BRL
        System.out.println("[Teste 1] Autorização em BRL:");
        boolean ok1 = processador.autorizar("4532-1234-5678-9012", 250.00, "BRL");
        System.out.println("Resultado: " + (ok1 ? "(v) APROVADO" : "(✗) NEGADO"));

        //  Transação USD
        System.out.println("\n[Teste 2] Autorização em USD:");
        boolean ok2 = processador.autorizar("5412-7534-8901-2345", 1500.00, "USD");
        System.out.println("Resultado: " + (ok2 ? "(v) APROVADO" : "(✗) NEGADO"));

        //  Transação EUR
        System.out.println("\n[Teste 3] Autorização em EUR:");
        boolean ok3 = processador.autorizar("6011-1234-5678-9012", 3200.50, "EUR");
        System.out.println("Resultado: " + (ok3 ? "(v) APROVADO" : "(✗) NEGADO"));

        //  Moeda inválida
        System.out.println("\n[Teste 4] Moeda inválida:");
        try {
            processador.autorizar("4532-1234-5678-9012", 100.00, "JPY");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ ERRO: " + e.getMessage());
        }
        
    }
}
