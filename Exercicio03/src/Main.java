import context.Usina;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONTROLE DE USINA NUCLEAR ===\n");

        Usina usina = new Usina();
        usina.exibirStatus();

        //  state.Desligada → Operação Normal
        System.out.println("\n[1] Inicializando usina:");
        usina.aumentarTemp(100);
        usina.exibirStatus();

        // Operação Normal → Alerta Amarelo
        System.out.println("\n[2] Temperatura elevando:");
        usina.aumentarTemp(200);
        usina.exibirStatus();

        // Alerta Amarelo → Alerta Vermelho (30s)
        System.out.println("\n[3] Temperatura crítica prolongada:");
        usina.aumentarTemp(120); // 420°C
        usina.aumentarTemp(10);  // Simula passar 30s
        usina.aumentarTemp(10);
        usina.aumentarTemp(10);
        usina.exibirStatus();

        // Alerta Vermelho → Emergência
        System.out.println("\n[4] Falha do resfriamento:");
        usina.falhaResfriamento();
        usina.exibirStatus();

        // Modo Manutenção
        System.out.println("\n[5] Testando modo manutenção:");
        Usina usina2 = new Usina();
        usina2.aumentarTemp(100);
        usina2.ativarManutenção();
        usina2.aumentarTemp(50); // Não funciona em manutenção
        usina2.desativarManutenção();
        usina2.exibirStatus();
        
    }
}
