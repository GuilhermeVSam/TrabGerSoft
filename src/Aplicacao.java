import com.departamentos.Departamentos;
import com.departamentos.Deptos;
import com.funcionarios.Funcionario;
import com.funcionarios.Funcionarios;
import com.utils.Categorias;
import com.utils.Comentario;
import com.utils.Custo;
import com.utils.RegistroCustos;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    Scanner in;
    Funcionarios funcionarios;
    Funcionario usuario; // usuário logado
    Departamentos departamentos;
    RegistroCustos listaCustos;
    int opcao;

    Aplicacao() {
        in = new Scanner(System.in);
        funcionarios = new Funcionarios();
        departamentos = new Departamentos();
        listaCustos = new RegistroCustos();

        Funcionario Pedro = new Funcionario("123", "Pedro", Deptos.ADMINISTRATIVO);
        Funcionario Robson = new Funcionario("456", "Robson", Deptos.ENGENHARIA);
        Funcionario Carla = new Funcionario("789", "Carla", Deptos.MARKETING);

        funcionarios.add(Pedro);
        funcionarios.add(Robson);
        funcionarios.add(Carla);

        Custo compras = new Custo(2500.00, "Compras", "29/09/2023", Categorias.AQUISICAO, Deptos.ADMINISTRATIVO);
        Custo ferramentas = new Custo(500.00, "ferramentas", "10/10/2023", Categorias.AQUISICAO, Deptos.ENGENHARIA);

        Pedro.somaCusto(compras);
        Robson.somaCusto(ferramentas);

        listaCustos.registrarCustos(compras);
        listaCustos.registrarCustos(ferramentas);
    }

    private void selecao() {
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        OPÇÕES                                         |");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| 1 - LISTAR FUNCIONÁRIOS                                                               |");
        System.out.println("| 2 - INCLUIR NOVO FUNCIONÁRIO                                                          |");
        System.out.println("| 3 - INSERIR NOVO REGISTRO DE CUSTO                                                    |");
        System.out.println("| 4 - PESQUISAR REGISTROS                                                               |");
        System.out.println("| 5 - EXCLUIR REGISTROS                                                                 |");
        System.out.println("| 6 - VISUALIZAR PAINEL DE INFORMAÇÕES SUPER ÚTEIS                                      |");
        System.out.println("| 7 - TROCAR USUÁRIO ATIVO                                                              |");
        System.out.println("| 8 - MOSTRAR COMENTÁRIOS DE UMA COMPRA                                                 |");
        System.out.println("| 9 - ADICIONAR COMENTÁRIO A UMA COMPRA                                                 |");
        System.out.println("| 0 - SAIR                                                                              |");
        System.out.println("+---------------------------------------------------------------------------------------+");
    }

    private void listarFuncionarios() {
        System.out.println("Funcionários: ");
        System.out.println(funcionarios);
    }

    private void registraFuncionario() {
        System.out.println("Cadastro de Funcionário");

        System.out.println("Informe a Matrícula: ");
        String matricula = in.nextLine();

        System.out.println("Informe o nome: ");
        String nome = in.nextLine();

        System.out.println("Informe o nome do departamento");
        String dptName = in.nextLine();
        Deptos aux = Deptos.fromString(dptName);

        if (aux == null) {
            System.out.println("Departamento não encontrado.");
            return;
        }

        System.out.println("Funcionario registrado!");
        funcionarios.add(new Funcionario(matricula, nome, aux));
    }

    // cadastrar uns departamentos, quem sabe usar enum
    private void novoRegistroDeCusto() {
        System.out.println("Informe o valor do custo: ");
        double valor = in.nextDouble();
        in.nextLine();

        System.out.println("Informe a descrição do custo: ");
        String descricao = in.nextLine();

        System.out.println("Informe a data do custo: ");
        String data = in.nextLine();

        System.out.println("Informe a categoria do custo(AQUISIÇÃO, MANUTENÇÃO, OUTROS): ");
        String categoriaEntrada = in.nextLine();
        Categorias categoria = Categorias.fromString(categoriaEntrada);

        System.out.println("Informe o departamento do custo (TI, RH, FINANCEIRO, ...): ");
        String departamentoEntrada = in.nextLine();

        // Obter o departamento usando o método getDepartamentoByName da classe Departamentos
        Deptos departamento = Deptos.fromString(departamentoEntrada);

        if (departamento == null) {
            System.out.println("Departamento não encontrado.");
            return;
        }

        Custo novoCusto = new Custo(valor, descricao, data, categoria, departamento);

        listaCustos.registrarCustos(novoCusto);
        usuario.somaCusto(novoCusto);

        System.out.println("Custo adicionado com sucesso!");
    }

    private void pesquisarRegistro() {
        ArrayList<Custo> aux = listaCustos.getRegistroCustos();
        for (Custo custo : aux) {
            System.out.println(custo);
        }
    }

    private void trocarUsuario() {
        System.out.println("Trocando usuário...");

        usuario = null;

        while (usuario == null) {
            System.out.print("Digite seu nome de usuário para continuar: ");
            String nome = in.nextLine();
            usuario = funcionarios.login(nome);
        }

        System.out.println("Login efetuado com succeso!");
    }

    private void excluirRegistroDeCusto() {
        listaCustos.excluirCustoRecente();
    }

    private void adicionarComentario() {
        System.out.println("Adicionar comentário a uma compra.");
        System.out.println("Digite a descrição do custo que deseja adicionar o comentário: ");
        System.out.print("# ");
        String descricao = in.nextLine();

        Custo custo = listaCustos.procuraPorDescricao(descricao);

        if (custo == null) {
            System.out.println("Custo não encontrado");
            return;
        }

        System.out.println("Custo encontrado. Adicione seu comentário: ");
        System.out.print("# ");

        String comentario = in.nextLine();

        Comentario com = new Comentario(comentario, usuario.getNome());

        custo.adicionarComentario(com);
    }

    private void mostrarComentarios() {
        System.out.println("Mostrar comentários de uma compra.");
        System.out.println("Digite a descrição do custo que deseja ver os comentários: ");
        System.out.print("# ");
        String descricao = in.nextLine();

        Custo custo = listaCustos.procuraPorDescricao(descricao);

        if (custo == null) {
            System.out.println("Custo não encontrado");
            return;
        }

        System.out.println(custo);

        List<Comentario> comentarios = custo.listarComentarios();

        for (Comentario c : comentarios) {
            System.out.println(c);
        }
    }

    public void exibirPainel() {
        ArrayList<Custo> c = listaCustos.getRegistroCustos();
        int mesAtual = 10;

        double custoMes = listaCustos.somaCustosPorMes(mesAtual);

        ArrayList<Funcionario> funcionariosDoMes = funcionarios.getMaioresLancadores(); // o nome desse método é genial

        StringBuilder funcionariosAsStr = new StringBuilder();
        for (int i = 0; i < 3 || i < funcionariosDoMes.size(); i++) {
            funcionariosAsStr.append(funcionariosDoMes.get(i).getNome());
            funcionariosAsStr.append(": ");
            funcionariosAsStr.append(funcionariosDoMes.get(i).getSomaCustos());
            funcionariosAsStr.append(" ");
        }

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        PAINEL DE DADOS                                |");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| FUNCIONARIO ATUALMENTE LOGADO: " + usuario.getNome());
        System.out.println("| OS 3 FUNCIONARIOS COM A MAIOR SOMA DE CUSTOS: " + funcionariosAsStr);
        System.out.println("| VALOR TOTAL DOS CUSTOS DO MÊS ATUAL (Outubro): R$" + custoMes);

        for (Deptos dep : Deptos.values()) {
            double custoDep = 0;

            for (Custo custo : c) {
                if (custo.getDepartamento() == dep && custo.getMes() >= mesAtual - 3) {
                    custoDep += custo.getValor();
                }
            }

            System.out.println("| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE " + dep.getNome() + ": R$" + custoDep);
        }
        System.out.println("+---------------------------------------------------------------------------------------+");
    }

    public void executar() {
        System.out.println("Bem vindo ao sistema!");

        while (usuario == null) {
            System.out.print("Digite seu nome de usuário para continuar: ");
            String nome = in.nextLine();
            usuario = funcionarios.login(nome);
        }

        System.out.println("Login efetuado com succeso!");

        do {
            selecao();
            System.out.print(usuario.getNome() + " # ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {//seria interessante um trycatch pra se a opção enrasse um char, eu n sei fazer trycatch
                            // seria mesmo, mas a gente confia no usuário :)
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    registraFuncionario();
                    break;
                case 3:
                    novoRegistroDeCusto();
                    break;
                case 4:
                    pesquisarRegistro();
                    break;
                case 5:
                    excluirRegistroDeCusto();
                    break;
                case 6://funcionando
                    exibirPainel();
                    break;
                case 7:
                    trocarUsuario();
                    break;
                case 8:
                    mostrarComentarios();
                    break;
                case 9:
                    adicionarComentario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("FALHA" + "\n" + "Por favor, insira uma opção válida.");  //implementar
                    break;
            }
        } while (opcao != 0);

        System.out.println("Desligando...");
    }
}
