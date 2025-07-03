package src;

public class Bairro {
    private String nome;
    private Cidade cidade;

    public Bairro(String nome, Cidade cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public Cidade getCidade() {
        return cidade;
    }
}
