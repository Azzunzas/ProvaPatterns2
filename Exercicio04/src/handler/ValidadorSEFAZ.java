package handler;

import model.NotaFiscal;
import model.ResultadoValidacao;

public class ValidadorSEFAZ extends Validador{
    private boolean forcarErro;

    public ValidadorSEFAZ(boolean forcarErro) {
        super(10, true); // Condicional: só executa se anteriores passarem
        this.forcarErro = forcarErro;
    }

    @Override
    public String getNome() { return "handler.Validador Servico SEFAZ"; }

    @Override
    protected ResultadoValidacao validarInterno(NotaFiscal nf) {
        // Dummy: simula consulta SEFAZ
        if (forcarErro) {
            return new ResultadoValidacao(false, "SEFAZ recusou NF-e");
        }
        return new ResultadoValidacao(true, "Autorizada pela SEFAZ");
    }
}
