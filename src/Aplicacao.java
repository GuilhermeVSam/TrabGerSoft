import com.departamentos.Departamentos;
import com.departamentos.Deptos;
import com.funcionarios.Funcionario;
import com.funcionarios.Funcionarios;
import com.utils.Categorias;
import com.utils.Custo;
import com.utils.RegistroCustos;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Scanner;

public class Aplicacao {
    Scanner in;
    Funcionarios funcionarios;
    Funcionario usuario = new Funcionario("123","Computador", null); // não modifica isso a menos q o departamento volte a funcionar, eu não consegui usar um objeto dpt
    Departamentos departamentos;
    RegistroCustos listaCustos;
    int opcao;

    Aplicacao(){
        in = new Scanner(System.in);
        funcionarios = new Funcionarios();
        departamentos = new Departamentos();
        listaCustos = new RegistroCustos();

        funcionarios.add(new Funcionario("123abc", "Robson", Deptos.ADMINISTRATIVO));
        funcionarios.add(new Funcionario("987zyx", "Carla", Deptos.MARKETING));
    }
    private void selecao () {
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        OPÇÕES                                         |"); // alguem centraliza isso? mó mão
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| 1 - LISTAR FUNCIONÁRIOS                                  \n" +
                           "| 2 - INCLUIR NOVO FUNCIONÁRIO                                            \n" +
                           "| 3 - INSERIR NOVO REGISTRO DE CUSTO                      \n" +
                           "| 4 - PESQUISAR REGISTROS                       \n" +
                           "| 5 - EXCLUIR REGISTROS                       \n" +
                           "| 6 - VISUALIZAR PAINEL DE INFORMAÇÕES SUPER ÚTEIS                      \n" +
                           "| 7 - FUNCIONALIDADE NOVA 1                \n" +
                           "| 8 - FUNCIONALIDADE NOVA 2               \n" +
                           "| 0 - SAIR                       ");
        System.out.println("+---------------------------------------------------------------------------------------+");
    }
    private void listarFuncionarios () {
        System.out.println("Funcionários: ");
        System.out.println(funcionarios);
    };
    private boolean registraFuncionario(){
        System.out.println("Cadastro de Funcionário");
        System.out.println("Informe a Matrícula: ");
        String matricula = in.nextLine();
        System.out.println("Informe o nome: ");
        String nome = in.nextLine();
        System.out.println("Informe o nome do departamento");
        String dptName = in.nextLine();
        Deptos aux = Deptos.fromString(dptName);
        if(aux == null) {
            System.out.println("Departamento não encontrado.");
            return false;
        }
        System.out.println("Funcionario registrado!");
        return funcionarios.add(new Funcionario(matricula, nome, aux));
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

        Custo novoCusto = new Custo(valor, descricao, data, categoria, departamento, usuario.getNome());

        listaCustos.registrarCustos(novoCusto);
        usuario.somaCusto(novoCusto);
    }
    private void pesquisarRegistro() {
        ArrayList<Custo> aux = listaCustos.getRegistroCustos();
        for (Custo custo : aux) {
            System.out.println("Descrição: " + custo.getDescricao());
            System.out.println("Valor: " + custo.getValor());
            System.out.println("Data: " + custo.getData());
        }
    }
    private void excluirRegistroDeCusto() {
        listaCustos.excluirCustoRecente();
    }; // implemnetar deve ser facil, pensei em colocar na pesqisa de registro
    public void exibirPainel(){
        ArrayList<Custo> c = listaCustos.getRegistroCustos();
        int mesAtual = 10;
        
        double custoMes = listaCustos.somaCustosPorMes(mesAtual);

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        PAINEL DE DADOS                                |");           //endireita
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| FUNCIONARIO ATUALMENTE LOGADO: "+usuario.getNome()+"                                  \n" +            //placeholders inseridos
                                                      "| OS 3 FUNCIONARIOS COM A MAIOR SOMA DE CUSTOS: Carlos, Roberto e Juliana                                        ");

        System.out.println("| VALOR TOTAL DOS CUSTOS DO MÊS ATUAL (Outubro): R$" + custoMes);
        
        for (Deptos dep : Deptos.values()){
            double custoDep = 0;

            for (Custo custo : c) {
                if (custo.getDepartamento() == dep && custo.getMes() >= mesAtual -3) {
                    custoDep += custo.getValor();
                } 
            }

            System.out.println("VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE " + dep.getNome() + ": R$" + custoDep);
        }
        System.out.println("+---------------------------------------------------------------------------------------+");
    }


    public void executar(){
        System.out.println("Bem vindo ao sistema!");
        listarFuncionarios();
        System.out.println("Digite seu nome de usuário para continuar: ");
        funcionarios.login(in.nextLine());
        System.out.println("Login efetuado com succeso!");
        System.out.println("Por favor, digite uma opção: ");
        do {
            selecao();
            opcao = in.nextInt();
            switch (opcao) {//seria interessante um trycatch pra se a opção enrasse um char, eu n sei fazer trycatch
                            // seria mesmo, mas a gente confia no usuário :)
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    registraFuncionario();
                    break;
                case 3:
                    novoRegistroDeCusto();             //implementar
                    break;                            // tentei implementar :) (vamos ver o que acontece)
                case 4:
                    pesquisarRegistro();          //implementar
                    break;
                case 5:
                    excluirRegistroDeCusto();
                    break;
                case 6://funcionando
                    exibirPainel();
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

      public static void exibirMenu() {

        System.out.println("Menu");
        System.out.println("1- Listar Funcionários");
        System.out.println("2- Registrar Funcionário");
        System.out.println("3- Novo Registro de Custo");
        System.out.println("4- Pesquisar Registro e Excluir Custo");
        System.out.println("5- Exibir Painel");
        System.out.println("6- Nova Funcionalidade 1: ");
        System.out.println("7- Nova Funcionalidade 2: ");
        System.out.println("8- Sair ");
        System.out.println("Escolha uma opção ");
     }

}
    /*public void inicializaDepartamentos(){           esse bixo ta inutil por enquanto
        Rh aux = new Rh("Recursos Humanos");
        departamentos.getDepartamentos().add(aux);
    }*/
     //queria fazer isso:
    //  RegistroCusto registro = new RegistroCusto(100.0, "Aquisição de material", new Date(), "Aquisição de Bens", "Departamento A");
      //  Comentario comentario1 = new Comentario("Ótima compra!", "Clara");
     //   Comentario comentario2 = new Comentario("Custo elevado!", "Maria");

       // registro.adicionarComentario(comentario1);
       // registro.adicionarComentario(comentario2);

       // List<Comentario> comentariosDoRegistro = registro.listarComentarios();
       // for (Comentario comentario : comentariosDoRegistro) {
       // comentario.exibirComentario();

    //public void exibirComentario() {
    // System.out.println("Autor:"+ autor);
   // System.out.println("Data:" + data);
   // System.out.println("Comentario:" + texto);
   // }