package src;

import java.util.ArrayList;

public class Comodo {
    private String nomeComodo;
    private int quantidadeDeAparelhos;
    private float consumoComodo;
    private ArrayList<EletroDomesticos> aparelhos;

    public Comodo(String nomeComodo, int quantidadeDeAparelhos, ArrayList<EletroDomesticos> aparelhos) {
        this.nomeComodo = nomeComodo;
        this.quantidadeDeAparelhos = quantidadeDeAparelhos;
        this.aparelhos = aparelhos;
        this.consumoComodo = 0;
        calcularConsumoComodo(); // Calcula no construtor
    }

    public ArrayList<EletroDomesticos> getAparelhos() {
        return aparelhos;
    }

    public void imprimirDetalhes() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║ Cômodo: " + nomeComodo);
        System.out.println("║ Aparelhos: " + quantidadeDeAparelhos);
        System.out.println("║ Consumo: " + consumoComodo + " kWh/mês");
        System.out.println("╠════════════════════════════════════════════╣");
        for (EletroDomesticos aparelho : aparelhos) {
            System.out.println("║  • " + aparelho);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public void calcularConsumoComodo() {
        consumoComodo = 0; // Resetar antes de calcular
        for (EletroDomesticos p : aparelhos) {
            consumoComodo += p.getConsumoDoAparelho();
        }
    }

    public String getNome() {
        return nomeComodo;
    }

    public float getConsumoTotal() {
        return consumoComodo;
    }

    @Override
    public String toString() {
        return String.format("%-20s | Aparelhos: %-2d | Consumo: %.2f kWh/mês",
            nomeComodo, quantidadeDeAparelhos, consumoComodo);
    }
}
