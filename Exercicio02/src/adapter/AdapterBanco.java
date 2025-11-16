package adapter;

import legacy.SistemaBancoLegado;
import target.ProcessadorDeTransacoes;

import java.util.HashMap;
import java.util.Map;

public class AdapterBanco implements ProcessadorDeTransacoes {
    private SistemaBancoLegado sistemaLegado;
    private String codigoBanco;

    public AdapterBanco(SistemaBancoLegado legado, String codigoBanco) {
        this.sistemaLegado = legado;
        this.codigoBanco = codigoBanco;
    }

    @Override
    public boolean autorizar(String cartao, double valor, String moeda) {
        System.out.println("\n[ADAPTER] Convertendo requisição moderna para legado...");

        // 1. Converte: Interface Moderna → Legado
        HashMap<String, Object> paramsLegado = new HashMap<>();
        paramsLegado.put("NUMERO_CARTAO", cartao);
        paramsLegado.put("VALOR_TRANSACAO", String.valueOf(valor)); // double → String
        paramsLegado.put("CODIGO_MOEDA", converterMoeda(moeda));    // String → Integer
        paramsLegado.put("CODIGO_BANCO", codigoBanco);               // Campo obrigatório
        paramsLegado.put("TIPO_OPERACAO", "COMPRA");                 // Campo obrigatório

        // 2. Chama sistema legado
        Map<String, Object> respostaLegado = sistemaLegado.processarTransacao(paramsLegado);

        // 3. Converte: Legado → Interface Moderna (BIDIRECIONAL)
        boolean sucesso = "APROVADO".equals(respostaLegado.get("STATUS"));
        System.out.println("  [ADAPTER] Resultado: " + respostaLegado.get("MENSAGEM"));

        return sucesso;
    }

    /**
     * Conversão de moeda: String → Código Legado
     * USD=1, EUR=2, BRL=3
     */
    private int converterMoeda(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default: throw new IllegalArgumentException("Moeda não suportada: " + moeda);
        }
    }
}
