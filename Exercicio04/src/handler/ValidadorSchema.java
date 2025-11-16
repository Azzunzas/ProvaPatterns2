package handler;

import model.NotaFiscal;
import model.ResultadoValidacao;

public class ValidadorSchema extends Validador{
    private boolean forcarErro;

    public ValidadorSchema(boolean forcarErro) {
        super(2, false);
        this.forcarErro = forcarErro;
    }

    @Override
    public String getNome() { return "handler.Validador Schema XML"; }

    @Override
    protected ResultadoValidacao validarInterno(NotaFiscal nf) {
        // Dummy: simula validação de XML contra XSD
        if (forcarErro) {
            return new ResultadoValidacao(false, "XML invalido contra XSD");
        }
        return new ResultadoValidacao(true, "Schema XML valido");
    }
}
