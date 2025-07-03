package src;

import java.util.ArrayList;
import src.Estado;
import src.Cidade;
import src.Bairro;
import src.Endereco;
import src.Imovel;


public class Sistema_SolarSmart {
    private PainelSolar painelsolar = new PainelSolar();
    private Orcamento orcamento = new Orcamento();
    private ArrayList<Usuarios> usuariosRegistrados = new ArrayList<>();
    private ArrayList<usuarioAdm> usuarioAdm = new ArrayList<>();
    Usuarios usuario; // Chamando a classe usuário para utilizá-la

    // ========================================
    // ========= FUNÇÕES IMÓVEL ===============
    // ========================================

    public void CadastroImovel(String email, String identificador, String Estado, String Cidade, String Bairro, String Rua, Regiao regiao, int numero, int cep, String Logradouro) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            if (usuario.ListImoveis(identificador)) {
                Estado estadoObj = new Estado(Estado, Estado.substring(0, 2), regiao);
                Cidade cidadeObj = new Cidade(Cidade, estadoObj);
                Bairro bairroObj = new Bairro(Bairro, cidadeObj);
                Endereco enderecoObj = new Endereco(Rua, bairroObj);

                Imovel imovel = new Imovel(identificador, enderecoObj, regiao, numero, cep, Logradouro);
                usuario.AdicionarImovel(imovel);

                opcoes.Imovel(identificador, Estado, Cidade, Bairro, Rua, regiao.getCodigoRegiao(), numero, cep, Logradouro);
                System.out.println("Imóvel cadastrado com sucesso.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }


    public boolean VerificaImovel(String email, String identificadorImovel) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            Imovel imovel = usuario.getImovelByIdentificador(identificadorImovel);
            if (imovel != null) {
                return true;
            }
        }
        System.out.println("❌ Imóvel não encontrado.");
        return false;
    }

    public void ListaComodoImovel(String email) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            usuario.ListImoveis(); // Sem envio de dados, ele não usa a sobrecarga para verificar se já existe
        }
    }

    public void EditImovel(String identificador) {
        if (usuario.VerificaImovel(identificador)) {
            // Implementar edição aqui
        }
    }

    public void RemoveImovel(String email, String identificador) {
        usuario = findUserByEmail(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado");
            return;
        }
        usuario.RemoveImovel(identificador);
    }

    
    
    // ========================================
    // === FUNÇÕES DE ADMINISTRADOR ===========
    // ========================================

    public void VerificaUsers() {
        if (usuariosRegistrados.isEmpty()) {
            System.out.println("Sistema não possui usuários registrados.");
            return;
        }
        for (Usuarios usuario : usuariosRegistrados) {
            System.out.println("Usuário: " + usuario.GetEmail());
        }
    }

    public void EditarUsuarios(String email) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            System.out.println("✅ Usuário permitido para edição.");
            System.out.println("📧 Email: " + usuario.GetEmail());
            usuario.EditUser(usuario.GetEmail());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void RemoverUsuarios(String email) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            usuariosRegistrados.remove(usuario);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void registrarADM(String email, String senha) {
        usuarioAdm admin = new usuarioAdm(email, senha);
        this.usuarioAdm.add(admin);
    }

    // =========================
    // === FUNÇÕES DE USUÁRIO ===
    // =========================

    public boolean veriUsuarios(String email) {
        for (Usuarios usuario : this.usuariosRegistrados) {
            if (usuario.GetEmail().equals(email)) {
                System.out.println("Este email já está registrado.");
                return false;
            }
        }
        return true;
    }

    public void CadastroUsuario(String email, String senha) {
        usuario = new Usuarios(email, senha);
        this.usuariosRegistrados.add(usuario);
    }

    public Usuarios findUserByEmail(String email) {
        for (Usuarios usuario : usuariosRegistrados) {
            if (usuario.GetEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    // ============================
    // === FUNÇÕES DE AUTENTICAÇÃO ==
    // ============================

    public usuarioAdm authadm(String email, String senha) {
        for (usuarioAdm adm : usuarioAdm) {
            if (adm.GetEmail().equals(email) && adm.GetSenha().equals(senha) && adm.getAdm()) {
                System.out.println("Login de ADM bem-sucedido! Bem-vindo, " + adm.GetEmail());
                return adm;
            }
        }
        System.out.println("Email ou senha de ADM incorretos.");
        return null;
    }

    public Usuarios AuthUser(String email, String senha) {
        for (Usuarios usuario : usuariosRegistrados) {
            if (usuario.GetEmail().equals(email) && usuario.GetSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.GetEmail());
                return usuario;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }

    // ============================
    // === FUNÇÕES DE CÔMODOS =====
    // ============================

    public void RegistrandoComodo(String email, String identificadorImovel, String nome, int QntAparelho, ArrayList<EletroDomesticos> aparelhos) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            Imovel imovel = usuario.getImovelByIdentificador(identificadorImovel);
            if (imovel != null) {
                Comodo comodo = new Comodo(nome, QntAparelho, aparelhos);
                imovel.adicionarComodo(comodo); // método que você precisa ter em Imovel
                System.out.println("✅ Cômodo adicionado com sucesso!");
            } else {
                System.out.println("❌ Imóvel não encontrado.");
            }
        } else {
            System.out.println("❌ Usuário não encontrado.");
        }
    }

    // ========================================
    // === CÁLCULOS DE CONSUMO E ORÇAMENTO ===
    // ========================================

    public void CalcularConsumoDeComodo(String email, String identificadorImovel, String nomeDoComodo) {
        usuario = findUserByEmail(email);

        if (usuario != null) {
            Imovel imovel = usuario.getImovelByIdentificador(identificadorImovel);

            if (imovel != null) {
                for (Comodo c : imovel.getComodos()) {
                    if (c.getNome().equalsIgnoreCase(nomeDoComodo)) {
                        float consumo = painelsolar.ObterConsumoComodo(c);
                        System.out.println("Consumo do cômodo '" + nomeDoComodo + "': " + consumo + " kWh");

                        // Ajuste aqui conforme sua implementação do painelsolar.Setregiao:
                        painelsolar.Setregiao(imovel.getRegiao().getCodigoRegiao());

                        painelsolar.ExibirPlacasDisponiveis();
                        painelsolar.CalcularConsumo(consumo);

                        double preco = painelsolar.Escolhido[1];
                        int quantidade = painelsolar.GetQuantidade();

                        orcamento.SetPreco(preco, quantidade, consumo);
                        boolean decisaoComodo = orcamento.CalcularOrcamento();
                        orcamento.MostrarDataHora();

                        if (decisaoComodo) {
                        	Fornecedores.ContatoFornecedor(painelsolar.getModelo());
                        }
                        return;
                    }
                }
                System.out.println("Cômodo '" + nomeDoComodo + "' não encontrado no imóvel.");
            } else {
                System.out.println("Imóvel com identificador '" + identificadorImovel + "' não encontrado.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void CalcularConsumoTotalImovel(String email, String identificadorImovel) {
        usuario = findUserByEmail(email);
        if (usuario != null) {
            Imovel imovel = usuario.getImovelByIdentificador(identificadorImovel);
            if (imovel == null) {
                System.out.println("❌ Imóvel não encontrado.");
                return;
            }

            if (imovel.getComodos().isEmpty()) {
                System.out.println("❌ Não há nenhum cômodo registrado neste imóvel.");
                return;
            }

            float consumoTotal = painelsolar.ObterConsumoTotalUsuario(imovel.getComodos());
            System.out.println("Consumo total do imóvel '" + identificadorImovel + "': " + consumoTotal + " kWh");

            painelsolar.Setregiao(imovel.getRegiao().getCodigoRegiao());
            painelsolar.ExibirPlacasDisponiveis();
            painelsolar.CalcularConsumo(consumoTotal);

            double preco = painelsolar.Escolhido[1];
            int quantidade = painelsolar.GetQuantidade();
            orcamento.SetPreco(preco, quantidade, consumoTotal);
            boolean decisaoTotal = orcamento.CalcularOrcamento();
            orcamento.MostrarDataHora();

            if (decisaoTotal) {
                Fornecedores.ContatoFornecedor(painelsolar.getModelo());
            }
        } else {
            System.out.println("❌ Usuário não encontrado.");
        }
    }
    
    
    
    
}
