package model;

public class ResultadoValidacao {
    private boolean sucesso;
    private String mensagem;

    public ResultadoValidacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
}
