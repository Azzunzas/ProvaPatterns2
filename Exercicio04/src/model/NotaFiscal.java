package model;

public class NotaFiscal {
    private String numero;
    private String xml;
    private boolean inseridaBanco;

    public NotaFiscal(String numero, String xml) {
        this.numero = numero;
        this.xml = xml;
        this.inseridaBanco = false;
    }

    public String getNumero() { return numero; }
    public String getXml() { return xml; }
    public boolean isInseridaBanco() { return inseridaBanco; }
    public void setInseridaBanco(boolean valor) { this.inseridaBanco = valor; }
}
