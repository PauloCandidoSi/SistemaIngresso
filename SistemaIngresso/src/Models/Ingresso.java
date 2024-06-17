package Models;

public class Ingresso {
    private String setor;
    private double valor;

    public Ingresso(String setor, double valor) {
        this.setor = setor;
        this.valor = valor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
