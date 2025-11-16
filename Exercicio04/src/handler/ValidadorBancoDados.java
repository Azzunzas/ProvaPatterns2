package handler;

import model.NotaFiscal;
import model.ResultadoValidacao;

public class ValidadorBancoDados extends Validador{
    private boolean forcarErro;

    public ValidadorBancoDados(boolean forcarErro) {
        super(2, false);
        this.forcarErro = forcarErro;
    }

    @Override
    public String getNome() { return "handler.Validador Banco de Dados"; }

    @Override
    protected ResultadoValidacao validarInterno(NotaFiscal nf) {
        // Dummy: simula inserção no banco
        if (!forcarErro) {
            nf.setInseridaBanco(true);
            System.out.println("Acao: NF-e inserida no banco de dados");
            return new ResultadoValidacao(true, "Numero unico, inserido");
        }
        return new ResultadoValidacao(false, "Numero duplicado");
    }

    @Override
    public void rollback(NotaFiscal nf) {
        // Rollback: remove do banco se foi inserida
        if (nf.isInseridaBanco()) {
            nf.setInseridaBanco(false);
            System.out.println("Acao: Removendo NF-e " + nf.getNumero() + " do banco");
        }
    }
}
