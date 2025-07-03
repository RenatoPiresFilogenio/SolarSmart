package src;

public class Regiao {
    private int codigoRegiao;
    private String nomeRegiao;
    public Regiao(int codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }

    public void Nomeregiao(int codigoRegiao) {
    	
    	switch (codigoRegiao) {
        case 1:
        	nomeRegiao = "Sudeste";
            break;
        case 2:
        	nomeRegiao = "Sul";
            break;
        case 3:
        	nomeRegiao = "Norte";
            break;
        case 4:
        	nomeRegiao = "Nordeste";
            break;
        case 5:
        	nomeRegiao = "Centro-Oeste";
            break;
        default:
        	nomeRegiao = "Região Inválida";
            break;
    }

    	
    }
    
    public int getCodigoRegiao() {
        return codigoRegiao;
    }

    public void setCodigoRegiao(int codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }
}
