package src;

public class Endereco {
    private String rua;
    private Bairro bairro;

    public Endereco(String rua, Bairro bairro) {
        this.rua = rua;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public Bairro getBairro() {
        return bairro;
    }
}
