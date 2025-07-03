package src;

public class Estado {
    private String nome;
    private String sigla;
    private Regiao regiao;

    public Estado(String nome, String sigla, Regiao regiao) {
        this.nome = nome;
        this.sigla = sigla;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }
}
