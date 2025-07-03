package src;

public class opcoes {

	public static void menu() {
		
		System.out.println();
		System.out.println("                  📋 MENU PRINCIPAL                  ");
		System.out.println("╠══════════════════════════════════════════════════╣");
		System.out.println("║  1️⃣  Registrar Cômodo e Aparelhos                ║");
		System.out.println("║  2️⃣  Verificar Imóveis Registrados               ║");
		System.out.println("║  3️⃣  Calcular Orçamento de um Cômodo do Imóvel   ║");
		System.out.println("║  4️⃣  Calcular Orçamento Total do Imóvel          ║");
		System.out.println("║  5️⃣  Cadastrar Imóvel                            ║");
		System.out.println("║  6️⃣  Remover Imóvel                              ║");
		System.out.println("║  7️⃣  Deslogar                                    ║");
		System.out.println("╚══════════════════════════════════════════════════╝");
		System.out.println();


		 	   
		    }
		
	
		public static void menu(boolean adm) {
			
			    	System.out.println("");
		            System.out.println("                  		📋MENU ADM                         ");
		            System.out.println("\t╔═══════════════════════════════════════════════════════╗");
		            System.out.println("\t║  1️⃣  Verificar Usuários                               ║");
		            System.out.println("\t║  2️⃣  Editar Usuários                                  ║");
		            System.out.println("\t║  3️⃣  Excluir Usuários                                 ║");
		            System.out.println("\t║  4️⃣  Deslogar                                         ║");
		            System.out.println("\t╚═══════════════════════════════════════════════════════╝\n");
			    }
			

	public static void regiao() {
	    System.out.println("\n\t🌎  Selecione sua Região:");
	    System.out.println("\t╔════════════════════════╗");
	    System.out.println("\t║  1️⃣  Sudeste           ║");
	    System.out.println("\t║  2️⃣  Sul               ║");
	    System.out.println("\t║  3️⃣  Norte             ║");
	    System.out.println("\t║  4️⃣  Nordeste          ║");
	    System.out.println("\t║  5️⃣  Centro-Oeste      ║");
	    System.out.println("\t╚════════════════════════╝\n");
	}

	public  static void bemvindo() {
		 System.out.println("");
	    System.out.println("		   🌞   Seja bem-vindo ao SolarSmart!⚡    	");
	    System.out.println("\n");
	}

	public static void logando() {	
		System.out.println("           🔐 MENU DE ACESSO         ");
		System.out.println("╠════════════════════════════════════╣");
		System.out.println("║  1️⃣  Logar                        ║");
		System.out.println("║  2️⃣  Registrar                    ║");
		System.out.println("║  3️⃣  Acesso ADM                   ║");
		System.out.println("║  4️⃣  Sair                         ║");
		System.out.println("╚════════════════════════════════════╝");
		System.out.print("👉 Escolha sua opção: ");

	}
	
	public static void Imovel(String Identificador, String estado, String cidade, String bairro, String rua, int Regiao, int numero, int cep, String logradouroCompleto) {
	    String regiaoImovel;
	    switch (Regiao) {
	        case 1:
	            regiaoImovel = "Sudeste";
	            break;
	        case 2:
	            regiaoImovel = "Sul";
	            break;
	        case 3:
	            regiaoImovel = "Norte";
	            break;
	        case 4:
	            regiaoImovel = "Nordeste";
	            break;
	        case 5:
	            regiaoImovel = "Centro-Oeste";
	            break;
	        default:
	            regiaoImovel = "Região Inválida";
	            break;
	    }

	    System.out.println("");
	    System.out.println("                  		📋 Imóvel                      ");
	    System.out.println("\t╔═══════════════════════════════════════════════════════╗");
	    System.out.println("\t║  Identificador: " + Identificador);
	    System.out.println("\t║  Estado: " + estado);
	    System.out.println("\t║  Cidade: " + cidade);
	    System.out.println("\t║  Bairro: " + bairro);
	    System.out.println("\t║  Rua: " + rua);
	    System.out.println("\t║  Número: " + numero);
	    System.out.println("\t║  CEP: " + cep);
	    System.out.println("\t║  Região: " + regiaoImovel);
	    System.out.println("\t║  Logradouro: " + logradouroCompleto);
	    System.out.println("\t╚═══════════════════════════════════════════════════════╝\n");
	}

}