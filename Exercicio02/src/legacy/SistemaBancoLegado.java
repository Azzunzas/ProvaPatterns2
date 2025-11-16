package legacy;

import java.util.HashMap;
import java.util.Map;

public class SistemaBancoLegado {

    public Map<String, Object> processarTransacao(HashMap<String, Object> params) {
        System.out.println("  [LEGADO] Processando: " + params);

        // Validação
        if (!params.containsKey("CODIGO_BANCO")) {
            return criarResposta(false, "Campo CODIGO_BANCO obrigatório");
        }
        if (!params.containsKey("TIPO_OPERACAO")) {
            return criarResposta(false, "Campo TIPO_OPERACAO obrigatório");
        }

        // Simula sucesso
        return criarResposta(true, "Aprovado");
    }

    private Map<String, Object> criarResposta(boolean sucesso, String msg) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("STATUS", sucesso ? "APROVADO" : "NEGADO");
        resp.put("MENSAGEM", msg);
        return resp;
    }
}
