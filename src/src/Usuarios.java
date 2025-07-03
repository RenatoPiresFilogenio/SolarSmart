package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {

    // Atributos privados (encapsulados)
    protected String email;
    protected String senha;
    protected ArrayList<Imovel> imoveisRegistrados;

    // Construtor para usuário comum
    public Usuarios(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.imoveisRegistrados = new ArrayList<>();
        
    }

    // Getters
    public String GetEmail() {
        return email;
    }

    public String GetSenha() {
        return senha;
    }

    public void SetSenha(String senha) {
        this.senha = senha;
    }

    // Adiciona um imóvel à lista do usuário
    public void AdicionarImovel(Imovel imovel) {
        this.imoveisRegistrados.add(imovel);
    }

    /**
     * Permite editar dados do usuário pelo terminal:
     * - Email
     * - Região
     */
    public void EditUser(String email) {
        Scanner scanner = new Scanner(System.in); // Evita usar o scanner global

        // Opção para alterar email
        System.out.println("Deseja alterar o email?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int opcaoEmail = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        if (opcaoEmail == 1) {
            System.out.print("Digite o novo email: ");
            String novoEmail = scanner.nextLine();
            this.email = novoEmail;
            System.out.println("✅ Email alterado para: " + novoEmail);
        }
    }

    public Imovel getImovelByIdentificador(String identificador) {
        for (Imovel imovel : imoveisRegistrados) {
            if (imovel.getIdentificador().equals(identificador)) {
                return imovel;
            }
        }
        return null; // Se não encontrar o imóvel
    }

    public void ListImoveis() {
        for (Imovel u : imoveisRegistrados) {
            System.out.println(u);
        }
    }

    public boolean ListImoveis(String identificador) { // verifica se identificador já existe
        for (Imovel u : imoveisRegistrados) {
            if (identificador.equals(u.getIdentificador())) {
                System.out.println("Imóvel já registrado");
                return false;
            }
        }
        return true;
    }

    public boolean VerificaImovel(String identificador) {
        for (Imovel u : imoveisRegistrados) {
            if (identificador.equals(u)) {
                return true;
            }
        }
        return false;
    }

    public void RemoveImovel(String identificador) {
        Imovel imovelParaRemover = null;
        for (Imovel imovel : imoveisRegistrados) {
            if (imovel.getIdentificador().equals(identificador)) {
                imovelParaRemover = imovel;
                break;
            }
        }
        if (imovelParaRemover != null) {
            imoveisRegistrados.remove(imovelParaRemover);
        }
    }
}
