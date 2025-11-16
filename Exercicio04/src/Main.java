import context.SistemaValidacaoNFe;
import model.NotaFiscal;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE VALIDACAO DE NF-e");
        System.out.println();

        SistemaValidacaoNFe sistema = new SistemaValidacaoNFe();

        //testes abaixo://

        // Todas validações passam
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTE: Todas validacoes passam");
        System.out.println("=".repeat(50));
        sistema.configurarCadeia(new boolean[]{false, false, false, false, false});
        NotaFiscal nf1 = new NotaFiscal("NF-001", "<xml>...</xml>");
        sistema.validar(nf1);

        // Schema XML inválido
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("TESTE: Schema XML invalido");
        System.out.println("=".repeat(50));
        sistema.configurarCadeia(new boolean[]{true, false, false, false, false});
        NotaFiscal nf2 = new NotaFiscal("NF-002", "<xml>invalido</xml>");
        sistema.validar(nf2);

        //  SEFAZ falha - Rollback do banco
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("TESTE: SEFAZ falha - Rollback do banco");
        System.out.println("=".repeat(50));
        sistema.configurarCadeia(new boolean[]{false, false, false, false, true});
        NotaFiscal nf3 = new NotaFiscal("NF-003", "<xml>...</xml>");
        sistema.validar(nf3);
        System.out.println("Status no banco: " + (nf3.isInseridaBanco() ? "INSERIDA" : "REMOVIDA"));

        // Circuit Breaker - 3 falhas
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("TESTE: Circuit Breaker (3 falhas)");
        System.out.println("=".repeat(50));
        sistema.configurarCadeia(new boolean[]{true, true, false, true, false});
        NotaFiscal nf4 = new NotaFiscal("NF-004", "<xml>...</xml>");
        sistema.validar(nf4);

        //  Validadores condicionais pulados
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("TESTE: Validadores condicionais pulados");
        System.out.println("=".repeat(50));
        sistema.configurarCadeia(new boolean[]{false, true, false, false, false});
        NotaFiscal nf5 = new NotaFiscal("NF-005", "<xml>...</xml>");
        sistema.validar(nf5);

    }
}
