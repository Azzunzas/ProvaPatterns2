package handler;

import model.NotaFiscal;
import model.ResultadoValidacao;

public class ValidadorRegrasFiscais extends Validador{
    private boolean forcarErro;

    public ValidadorRegrasFiscais(boolean forcarErro) {
        super(5, true); // Condicional: só executa se anteriores passarem
        this.forcarErro = forcarErro;
    }

    @Override
    public String getNome() { return "handler.Validador Regras Fiscais"; }

    @Override
    protected ResultadoValidacao validarInterno(NotaFiscal nf) {
        // Dummy: simula cálculo de impostos
        if (forcarErro) {
            return new ResultadoValidacao(false, "ICMS calculado incorretamente");
        }
        return new ResultadoValidacao(true, "Impostos corretos");
    }
}
