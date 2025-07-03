package src;

public class Fornecedores {
	
    private static String nome;
    private static String Telefone;
    private static String email;
    
    public static void ContatoFornecedor(String escolha) {
       
        nome = "";
        Marcas.pegarSite(escolha);
        Marcas.paisOrigem(escolha);
        Marcas.data(escolha);
        

        switch (escolha) {
        case "SunVolt Pro 500":
        	nome = "SunVolt Brasil";
            Telefone = "(11) 99999-5000";
            email = "contato@sunvolt.com.br";
            
            break;
        case "HelioTitan 550":
        	nome = "HelioTech Distribuidora";
            Telefone = "(21) 98888-5500";
            email = "contato@heliotech.com";
            
            break;
        case "EcoPower Ultra 600":
        	nome = "EcoPower Solutions";
            Telefone = "(31) 97777-6000";
            email = "vendas@ecopower.com";
           
            break;
        case "SolarCore X 650":
        	nome = "SolarCore Energia";
            Telefone = "(41) 96666-6500";
            email = "comercial@solarcore.com.br";
            
            break;
        case "PhotonStorm 700":
        	nome = "PhotonStorm Distribuição";
            Telefone = "(51) 95555-7000";
            email = "contato@photonstorm.com";
           
            break;
        default:
            System.out.println("Potência não reconhecida. Nenhum fornecedor encontrado.");
            return;
    }

        System.out.println("\nInformações do fornecedor selecionado:");
        System.out.println("Fornecedor: " + nome);
        System.out.println("Telefone: " + Telefone);
        System.out.println("Email: " + email);
        System.out.println("Site Oficial: " + Marcas.GetSite());
        System.out.println("País de origem: " + Marcas.GetPais());
        System.out.println("Data de criação: " + Marcas.GetData());

    }
}