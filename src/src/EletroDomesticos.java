 package src;

public class EletroDomesticos {
    private String nomeAparelho;
    private float consumoDoAparelho;

   
    public EletroDomesticos(String nomeAparelho, float consumoDoAparelho) {
        this.nomeAparelho = nomeAparelho;
        this.consumoDoAparelho = consumoDoAparelho;
    }

   
    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }

    public float getConsumoDoAparelho() {
        return consumoDoAparelho;
    }

    public void setConsumoDoAparelho(float consumoDoAparelho) {
        this.consumoDoAparelho = consumoDoAparelho;
    }

    
    @Override
    public String toString() {
        return "Aparelho: " + nomeAparelho + " | Consumo: " + consumoDoAparelho + " kWh";
    }
}
