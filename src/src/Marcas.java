package src;

public class Marcas {
	private static String modelo;
	private static String data_cadastro;
	private static String site_oficial;
	private static String pais_origem;
	Fornecedores fornecedor;
	
	public static String GetPais() {
		return pais_origem;
	  }
	
	public static String GetSite() {
		return site_oficial;
	}
	
	public static String GetData() {
		return data_cadastro;
	}
	
	
	public static void ShowMarca() {
		System.out.println("======= Dados em Marca ======");
		System.out.println(modelo);
		System.out.println(data_cadastro);
		System.out.println(site_oficial);
		System.out.println(pais_origem);
	}
	
    public static String pegarModelo(String escolha) {
    	
        switch (escolha) {
            case "SunVolt Pro 500":
            	modelo = escolha;
                return "SunVolt Pro 500";
            case "HelioTitan 550":
            	modelo = escolha;
                return "HelioTitan 550";
            case "EcoPower Ultra 600":
            	modelo = escolha;
                return "EcoPower Ultra 600";
            case "SolarCore X 650":
            	modelo = escolha;
                return "SolarCore X 650";
            case "PhotonStorm 700":
            	modelo = escolha;
                return "PhotonStorm 700";
            default:
                return "Modelo desconhecido";
        }
    }
    
  public static String pegarSite(String escolha) {  
	  
	  

	  switch (escolha) {
	      case "SunVolt Pro 500":
	    	  site_oficial = "site_oficial = https://www.sunvolt.com.br";
	    	  return   site_oficial;
	      case "HelioTitan 550":
	    	  site_oficial = "site_oficial = https://www.heliotech.com.br";
	    	  return  site_oficial;         
	          
	      case "EcoPower Ultra 600":
	    	  site_oficial = "site_oficial = https://www.ecopower.com.br";
	    	  return site_oficial;	        
	         
	      case "SolarCore X 650":
	    	  site_oficial = "site_oficial = https://www.solarcoreenergia.com.br";
	    	  return   site_oficial;	         
	          
	      case "PhotonStorm 700":
	    	  site_oficial = "site_oficial = https://www.photonstorm.com.br";
	    	  return  site_oficial;         
	         
	      default:
	         return "Site nao encontrado";
	  }

	  
  }
  
public static String paisOrigem(String escolha) {  
	  
	

	  switch (escolha) {
	    case "SunVolt Pro 500":
	    	pais_origem = "Brasil";
	        return pais_origem;
	        
	    case "HelioTitan 550":
	    	pais_origem = "Estados Unidos";
	        return pais_origem;
	        
	    case "EcoPower Ultra 600":
	    	pais_origem = "Alemanha";
	        return pais_origem;
	        
	    case "SolarCore X 650":
	    	pais_origem = "Japão";
	        return pais_origem;
	        
	    case "PhotonStorm 700":
	    	pais_origem = "Canadá";
	        return pais_origem;
	        
	    default:
	        return "País desconhecido";
	}

	
  }

public static String data(String escolha) {  
	  
	  switch (escolha) {
	    case "SunVolt Pro 500":
	    	data_cadastro = "1998";
	        return data_cadastro;
	        
	    case "HelioTitan 550":
	    	data_cadastro = "2005";
	        return data_cadastro;
	        
	    case "EcoPower Ultra 600":
	    	data_cadastro = "2010";
	        return data_cadastro;
	        
	    case "SolarCore X 650":
	    	data_cadastro = "2003";
	        return data_cadastro;
	        
	    case "PhotonStorm 700":
	    	data_cadastro = "2015";
	        return data_cadastro;
	        
	    default:
	        return "Data de criação desconhecida";
	}

	
	  
}


}