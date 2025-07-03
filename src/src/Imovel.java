package src;

import java.util.ArrayList;

public class Imovel {
    private String identificador;
    private String logradouro;
    private int cep;
    private int numero;
    private Endereco FK_ID_BAIRROS;
    private Regiao regiao;
    private ArrayList<Comodo> comodos = new ArrayList<>();
    
    public Imovel(String identificador, Endereco endereco, Regiao regiao, int numero , int cep, String logradouro) {
        this.identificador = identificador;
        this.FK_ID_BAIRROS = endereco;
        this.regiao = regiao;
        this.logradouro = logradouro;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Endereco getEndereco() {
        return FK_ID_BAIRROS;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public ArrayList<Comodo> getComodos() {
        return comodos;
    }

    public void adicionarComodo(Comodo comodo) {
        comodos.add(comodo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔══════════════════════════════════════════════╗\n");
        sb.append(String.format("║ %-44s ║\n", "🏷️ Identificador: " + identificador));
        sb.append(String.format("║ %-44s ║\n", "📍 Logradouro: " + logradouro));
        sb.append("║                                              ║\n");
        sb.append(String.format("║ %-44s ║\n", "🗺️ Endereço Completo:"));
        sb.append(String.format("║   %-42s ║\n", "Estado: " + FK_ID_BAIRROS.getBairro().getCidade().getEstado().getNome()));
        sb.append(String.format("║   %-42s ║\n", "Cidade: " + FK_ID_BAIRROS.getBairro().getCidade().getNome()));
        sb.append(String.format("║   %-42s ║\n", "Bairro: " + FK_ID_BAIRROS.getBairro().getNome()));
        sb.append(String.format("║   %-42s ║\n", "Rua: " + FK_ID_BAIRROS.getRua()));
        sb.append(String.format("║ %-44s ║\n", "🌎 Região: " + regiao.getCodigoRegiao()));
        sb.append("╠══════════════════════════════════════════════╣\n");

        sb.append(String.format("║ %-44s ║\n", "🛋️ Cômodos:"));
        if (!comodos.isEmpty()) {
            for (Comodo comodo : comodos) {
                // Para manter alinhamento e borda, corta ou ajusta o texto do cômodo caso seja longo
                String linhaComodo = comodo.toString();
                if (linhaComodo.length() > 42) {
                    linhaComodo = linhaComodo.substring(0, 39) + "...";
                }
                sb.append(String.format("║   - %-41s ║\n", linhaComodo));
            }
        } else {
            sb.append(String.format("║   %-42s ║\n", "Nenhum cômodo registrado."));
        }
        sb.append("╚══════════════════════════════════════════════╝\n");

        return sb.toString();
    }
}
