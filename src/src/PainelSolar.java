package src;

import java.util.ArrayList;
import java.util.Scanner;
public class PainelSolar {
	Scanner scanner = new Scanner(System.in);
    int regiaoUser;
    float ConsumoUsuario;
   double [] Escolhido = new double[4]; //0 é potencia da placa  e 1 é preço da placa e o 3 é a potencia original
   String modeloEscolhido;
   int horasSolPorDia;
   int QuantidadePlaca;
   int producaoDiaria;
   int producaoMensal;
    String[] modelos = {
        "SunVolt Pro 500", 		//0
        "HelioTitan 550", 		//1
        "EcoPower Ultra 600",   //2
        "SolarCore X 650",		//3
        "PhotonStorm 700"		//4
    };

 int [] PotenciaWatts = {
        500,
        550,
        600,
        650,
        700
    };
    
    double [] VALOR_UNITARIO = {
    		1500,
    		1800,
    		2000,
    		2200,
    		2500
    };

    public float ObterConsumoComodo(Comodo comodo) {
        this.ConsumoUsuario = comodo.getConsumoTotal();
        return comodo.getConsumoTotal(); 
    }

    public float ObterConsumoTotalUsuario(ArrayList<Comodo> comodos) {
        float total = 0;
        for (Comodo c : comodos) {
            total += c.getConsumoTotal(); 
        }
        return total;
    }

    public void Setregiao(int regiao) {
    	this.regiaoUser = regiao;
       

        switch (regiao) {
            case 1: // Sudeste
                this.horasSolPorDia = 5;  
                break;
            case 2: // Sul
            	 this.horasSolPorDia = 4;  
                break;
            case 3: // Norte
            	 this.horasSolPorDia = 6; 
                break;
            case 4: // Nordeste
            	 this.horasSolPorDia = 7;  
                break;
            case 5: // Centro-Oeste
            	 this.horasSolPorDia = 6;  
                break;
            default:
                horasSolPorDia = 0;  
                System.out.println("Região inválida. Horas de sol não definidas.");
                break;}
    }

    public void CalcularConsumo(float consumo){
    	int quantidade = 0;
    	double potenciaOriginal = Escolhido[0];
    	int potenciaTotal = 0;

    	while (potenciaTotal < consumo) {
    	    potenciaTotal += potenciaOriginal;
    	    quantidade++;
    	}

    	Escolhido[0] = potenciaTotal;
    	this.QuantidadePlaca = quantidade;
       System.out.println("O seu consumo é " + consumo + " com a placa escolhida o total de placas necessárias serão " + quantidade  + " produzindo " + Escolhido[0]  + " Kwh/mensal");
    }


    public void ExibirPlacasDisponiveis() {
        
        System.out.println("Escolha uma das placas solares abaixo:");

       
        for (int i = 0; i < modelos.length; i++) {
        	 System.out.printf(" %d. %s - %dW - Preço: R$ %.2f\n", i + 1, modelos[i], PotenciaWatts[i], VALOR_UNITARIO[i]);
        }

   
        System.out.print("\nEscolha a placa (1-5): ");
        int escolha = scanner.nextInt();

        
        if (escolha >= 1 && escolha <= modelos.length) {
            System.out.println("\nVocê escolheu a placa: " + modelos[escolha - 1]);
            System.out.println("Potência: " + PotenciaWatts[escolha - 1] + "W");
            System.out.println("Preço R$: " + VALOR_UNITARIO[escolha - 1]);
            producaoDiaria = (PotenciaWatts[escolha - 1] * horasSolPorDia) / 1000; 
            producaoMensal = producaoDiaria * 30; 
            System.out.println("Potência média mensal gerada: " + producaoMensal + " kWh");
            Escolhido[0] = producaoMensal;
            Escolhido[3] = PotenciaWatts[escolha - 1];
            Escolhido[1] = VALOR_UNITARIO[escolha - 1]; 
            modeloEscolhido = modelos[escolha - 1];
        } else {
            
            System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 5.");
        }
    }
    
    public double GetPreço() {
    	return Escolhido[1];
    }
    
    public double GetPotencia() {
    	return Escolhido[0];
    }
    
    public int GetQuantidade() {
        return QuantidadePlaca;
    }
    
    public double potenciaFornecedor(){
    	return Escolhido[3];
    }
    
    public String getModelo() {
    	return modeloEscolhido;
    }
    
}

