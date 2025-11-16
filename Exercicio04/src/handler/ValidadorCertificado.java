package handler;

import model.NotaFiscal;
import model.ResultadoValidacao;

public class ValidadorCertificado extends Validador{
    private boolean forcarErro;

    public ValidadorCertificado(boolean forcarErro) {
        super(3, false);
        this.forcarErro = forcarErro;
    }

    @Override
    public String getNome() { return "handler.Validador Certificado Digital"; }

    @Override
    protected ResultadoValidacao validarInterno(NotaFiscal nf) {
        // Dummy: simula verificação de certificado
        if (forcarErro) {
            return new ResultadoValidacao(false, "Certificado expirado");
        }
        return new ResultadoValidacao(true, "Certificado valido");
    }
}
