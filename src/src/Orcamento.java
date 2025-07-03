package src;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Orcamento {	
	 Scanner scanner = new Scanner(System.in);
	private double PrecoPlaca;
	 int QuantidadePlaca;
	 double Valor_total;
	Imovel imovel;
	public void SetPreco(double preco, int QuantidadePlaca, float consumo){
		this.PrecoPlaca = preco;
		this.QuantidadePlaca = QuantidadePlaca;
		
	}
	public double GetPreco() {
		return PrecoPlaca;
	}
	
	public void MostrarDataHora() {
	    LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    String dataHoraFormatada = agora.format(formato);
	    System.out.println("Data e hora da geração do orçamento: " + dataHoraFormatada);
	    
	}


	
	public boolean CalcularOrcamento() {
		this.Valor_total = PrecoPlaca * QuantidadePlaca; 
		System.out.println("O preço total das placas ficaram: "+ Valor_total);
		System.out.println("");
		System.out.println("Deseja o contato do fornecedor?");
		System.out.println("1 - sim");
		System.out.println("qualquer outro numero é não");
		int escolha = scanner.nextInt();
	if(escolha == 1){
		return true;
	}else {
		return false;
	}

	}
}
