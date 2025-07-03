package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Instancia o sistema principal
        Sistema_SolarSmart SolarSmart = new Sistema_SolarSmart();
        Scanner scanner = new Scanner(System.in);

        // Flags de controle
        boolean admlogado = false; // Flag para indicar se o administrador está logado
        boolean sistemaRodando = true; // Flag principal de loop
        Usuarios usuarioLogado = null; // Condição que define se o usuário esta logado ou não

        // Registra o administrador padrão
        SolarSmart.registrarADM("adm", "123");

        // Exibe mensagem inicial de boas-vindas
        opcoes.bemvindo();

        // Loop principal do sistema
        while (sistemaRodando) {

            // Loop de autenticação: continua até que um usuário faça login
            while (usuarioLogado == null) {
            	opcoes.logando();
                int decisao = scanner.nextInt();
                scanner.nextLine(); // Limpa buffer

                switch (decisao) {
                    case 1: // Login de usuário comum
                        System.out.println("\n[LOGIN]");
                        System.out.print("Email: ");
                        String emailLogin = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senhaLogin = scanner.nextLine();

                        usuarioLogado = SolarSmart.AuthUser(emailLogin, senhaLogin);
                        break;

                    case 2: // Registro de novo usuário
                        System.out.println("\n[REGISTRO]");
                        System.out.print("Novo Email: ");
                        String emailRegistro = scanner.nextLine();
                        while(SolarSmart.veriUsuarios(emailRegistro)==false){
                         emailRegistro = scanner.nextLine();
                        }
                        System.out.print("Nova Senha: ");
                        String senhaRegistro = scanner.next();
                        
                        
                      // Limpa buffer

                        SolarSmart.CadastroUsuario(emailRegistro, senhaRegistro);
                        break;

                    case 4: // Sair do sistema
                        System.out.println("\n🛑 Encerrando o sistema... Até logo!");
                        System.exit(0);
                        break;

                    case 3: // Login como administrador
                        System.out.println("\nLogando como ADM");
                        System.out.print("Email: ");
                        String admlog = scanner.nextLine();
                        System.out.print("Senha: ");
                        String admsenha = scanner.nextLine();

                        usuarioLogado = SolarSmart.authadm(admlog, admsenha);
                        if (usuarioLogado != null) {
                            admlogado = true;
                        }
                        break;

                    default:
                        System.out.println("\n❌ Opção inválida. Tente novamente.");
                        break;
                }
            }

            // ========== MENU DO USUÁRIO COMUM ==========
            if (!admlogado) {
            	opcoes.menu();
                System.out.print("→ ");
                int decisao = scanner.nextInt();
                scanner.nextLine();

                switch (decisao) {
                    case 1: // Registrar cômodos e aparelhos no imovel
                    	System.out.println("Digite exatamente o imovel que deseja cadastrar os cômodos");
                    	String identificadorImovel = scanner.next();
                    	if(SolarSmart.VerificaImovel(usuarioLogado.GetEmail(), identificadorImovel) == true){
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║        📋 REGISTRO DE CÔMODOS          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        System.out.print("🔢 Quantos cômodos deseja registrar? ");
                        int qtdComodos = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < qtdComodos; i++) {
                            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                            System.out.println("🏠  Cômodo " + (i + 1));
                            System.out.print("📝 Nome do cômodo: ");
                            String nomeComodo = scanner.nextLine();

                            System.out.print("Quantos aparelhos deseja adicionar? ");
                            int qtdAparelhos = scanner.nextInt();
                            scanner.nextLine();

                            ArrayList<EletroDomesticos> aparelhos = new ArrayList<>();

                            for (int j = 0; j < qtdAparelhos; j++) {
                                System.out.println("\n   📦 Aparelho " + (j + 1));
                                System.out.print("   🔤 Nome do aparelho: ");
                                String nomeAparelho = scanner.nextLine();

                                System.out.print("   ⚡ Consumo mensal (kWh): ");
                                float consumoAparelho = scanner.nextFloat();
                                scanner.nextLine();

                                aparelhos.add(new EletroDomesticos(nomeAparelho, consumoAparelho));
                            }

                            SolarSmart.RegistrandoComodo(usuarioLogado.GetEmail(),identificadorImovel, nomeComodo, qtdAparelhos, aparelhos);
                        }}
                        break;

                    case 2: // Verificar imoveis
                        System.out.println("\n📋 ════════════════════════════════");
                        System.out.println("     🏠 LISTA DE IMOVEIS REGISTRADOS");
                        System.out.println("═══════════════════════════════════\n");
                        SolarSmart.ListaComodoImovel(usuarioLogado.GetEmail());
                        break;

                    case 3: // Calcular consumo de um cômodo específico
                    	System.out.print("\n📝 Digite o identificador exato do imovel: ");
                        String nomeImovel = scanner.nextLine();
                        System.out.print("\n📝 Digite o nome exato do cômodo: ");
                        String nomeComodo = scanner.nextLine();
                        SolarSmart.CalcularConsumoDeComodo (usuarioLogado.GetEmail(),nomeImovel,nomeComodo);
                        break;

                    case 4: // Calcular consumo total
                    	System.out.print("\n📝 Digite o identificador exato do imovel: ");
                        String enviarImovel = scanner.nextLine();
                    	if(SolarSmart.VerificaImovel(usuarioLogado.GetEmail(), enviarImovel) == true) {
                        System.out.println("\n💡 Calculando o imovel:");
                        SolarSmart.CalcularConsumoTotalImovel(usuarioLogado.GetEmail(), enviarImovel);}
                    	else {
                    		 System.out.println("\n Imovel não existe..");
                    	} 	
                        break;

                    case 7: // Logout
                        System.out.println("\n🔒 Encerrando sessão...");
                        System.out.println("👋 Até logo! Obrigado por usar o SmartSolar.");
                        usuarioLogado = null;
                        break;
                        
                    case 5: // Cadastra imóvel
                    	System.out.println("\n📝 Cadastrar imóvel... ");

                    	System.out.print("\n📝 Registre o identificador da casa (nome para achar no sistema): ");
                    	String identificador = scanner.nextLine();

                    	System.out.print("\n📝 Registre o logradouro: ");
                    	String logradouro = scanner.nextLine();

                    	System.out.print("\n📝 Registre o Estado (mínimo 2 caracteres): ");
                    	String estado = scanner.nextLine();
                    	while (estado.length() < 2) {
                    	    System.out.println("⚠️ Estado inválido! Por favor, informe pelo menos 2 caracteres.");
                    	    System.out.print("\n📝 Registre o Estado (mínimo 2 caracteres): ");
                    	    estado = scanner.nextLine();
                    	}

                    	System.out.print("\n📝 Registre a Cidade: ");
                    	String cidade = scanner.nextLine();

                    	System.out.print("\n📝 Registre o Bairro: ");
                    	String bairro = scanner.nextLine();

                    	System.out.print("\n📝 Registre a Rua: ");
                    	String rua = scanner.nextLine();

                    	int numero = 0;
                    	while (true) {
                    	    System.out.print("\n📝 Registre o Número (somente números): ");
                    	    String input = scanner.nextLine();
                    	    try {
                    	        numero = Integer.parseInt(input);
                    	        if (numero <= 0) {
                    	            System.out.println("⚠️ Número inválido! Por favor, informe um número maior que zero.");
                    	            continue;
                    	        }
                    	        break;
                    	    } catch (NumberFormatException e) {
                    	        System.out.println("⚠️ Entrada inválida! Por favor, digite um número inteiro válido.");
                    	    }
                    	}

                    	int cep = 0;
                    	while (true) {
                    	    System.out.print("\n📝 Registre o CEP (somente números, sem hífen): ");
                    	    String input = scanner.nextLine();
                    	    try {
                    	        cep = Integer.parseInt(input);
                    	        if (cep <= 0) {
                    	            System.out.println("⚠️ CEP inválido! Por favor, informe um número maior que zero.");
                    	            continue;
                    	        }
                    	        break;
                    	    } catch (NumberFormatException e) {
                    	        System.out.println("⚠️ Entrada inválida! Por favor, digite um número inteiro válido para o CEP.");
                    	    }
                    	}

                    	int codigoRegiao = -1;
                    	while (codigoRegiao < 1 || codigoRegiao > 5) {
                    	    opcoes.regiao(); // Exibe opções de região
                    	    System.out.print("Escolha a região (1 a 5): ");
                    	    String input = scanner.nextLine();
                    	    try {
                    	        codigoRegiao = Integer.parseInt(input);
                    	        if (codigoRegiao < 1 || codigoRegiao > 5) {
                    	            System.out.println("⚠️ Região inválida! Escolha um número entre 1 e 5.");
                    	        }
                    	    } catch (NumberFormatException e) {
                    	        System.out.println("⚠️ Entrada inválida! Por favor, digite um número inteiro entre 1 e 5.");
                    	    }
                    	}

                    	Regiao regiao = new Regiao(codigoRegiao);

                    	SolarSmart.CadastroImovel(usuarioLogado.GetEmail(), identificador, estado, cidade, bairro, rua, regiao, numero, cep, logradouro);

                    	System.out.println("\n✅ Imóvel cadastrado com sucesso!");
                    	break;
                    case 6:
                        System.out.println("Deseja remover algum imóvel?");
                        int removeImovel = 0;	

                        while (removeImovel != 1 && removeImovel != 2) {
                            System.out.print("Digite 1 para Sim ou 2 para Não: ");
                            if(scanner.hasNextInt()) {
                                removeImovel = scanner.nextInt();
                                scanner.nextLine(); // Limpa o \n após nextInt()
                            } else {
                                System.out.println("Entrada inválida. Tente novamente.");
                                scanner.nextLine(); // Limpa entrada inválida
                                continue;
                            }
                        }

                        if (removeImovel == 1) {
                            System.out.print("\n📝 Digite o identificador exato do imóvel: ");
                            String envImovel = scanner.nextLine();
                            if (SolarSmart.VerificaImovel(usuarioLogado.GetEmail(), envImovel)) {
                            	SolarSmart.RemoveImovel(usuarioLogado.GetEmail(), envImovel);
                                System.out.println("✅ Imóvel removido com sucesso.");
                            }
                        } else {
                            System.out.println("Ação cancelada");
                        }
                        break;

                    default:
                        System.out.println("\n❌ Opção inválida. Tente novamente.");
                        break;
                }
            }

            // ========== MENU DO ADMINISTRADOR ==========
            if (admlogado) {
                opcoes.menu(admlogado);
                System.out.print("→ ");
                int decisao = scanner.nextInt();
                scanner.nextLine();

                switch (decisao) {
                    case 1: // Ver todos os usuários
                    	SolarSmart.VerificaUsers();
                        break;

                    case 2: // Editar usuário por e-mail
                        System.out.print("Digite o email do usuário que deseja editar: ");
                        String editUser = scanner.next();
                        SolarSmart.EditarUsuarios(editUser);
                        break;

                    case 3: // Remover usuário por e-mail
                        System.out.print("Digite o email do usuário que deseja remover: ");
                        String removeUser = scanner.next();
                        SolarSmart.RemoverUsuarios(removeUser);
                        break;

                  
                    case 4: // Logout do ADM
                        System.out.println("\n🔒 Encerrando sessão ADM...");
                        admlogado = false;
                        usuarioLogado = null;
                        break;


                    default:
                        System.out.println("\n❌ Opção inválida. Tente novamente.");
                        break;
                }
            }
        }

        scanner.close(); // Fecha o Scanner ao final da execução
    }
}
