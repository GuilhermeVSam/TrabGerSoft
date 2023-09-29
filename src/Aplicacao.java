import com.departamentos.Departamento;
import com.departamentos.Departamentos;
import com.departamentos.Deptos;
import com.departamentos.Rh;
import com.funcionarios.Funcionario;
import com.funcionarios.Funcionarios;

import java.util.Scanner;

public class Aplicacao {
    Scanner in;
    Funcionarios funcionarios;
    Funcionario usuario = new Funcionario("123","Computador", null); // não modifica isso a menos q o departamento volte a funcionar, eu não consegui usar um objeto dpt
    Departamentos departamentos;
    int opcao;

    Aplicacao(){
        in = new Scanner(System.in);
        funcionarios = new Funcionarios();
        departamentos = new Departamentos();

    }
    private void selecao () {
        System.out.println("\n");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        OPÇÕES                                         |"); // alguem centraliza isso? mó mão
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| 1 - MUDAR FUNCIONÁRIO LOGADO                                  \n" +
                           "| 2 - INCLUIR NOVO FUNCIONÁRIO                                            \n" +
                           "| 3 - INSERIR NOVO REGISTRO DE CUSTO                      \n" +
                           "| 4 - PESQUISAR REGISTROS                       \n" +
                           "| 5 - VISUALIZAR PAINEL DE INFORMAÇÕES SUPER ÚTEIS                      \n" +
                           "| 6 - FUNCIONALIDADE NOVA 1                \n" +
                           "| 7 - FUNCIONALIDADE NOVA 2                    \n");
        System.out.println("+---------------------------------------------------------------------------------------+\n\n");
    }
    private void listarFuncionarios () {}; //implementar, precisa que funcionarios existam antes
    private boolean registraFuncionario(){
        System.out.println("Cadastro de Funcionário");
        System.out.println("Informe a Matrícula: ");
        String matricula = in.nextLine();
        System.out.println("Informe o nome: ");
        String nome = in.nextLine();
        System.out.println("Informe o nome do departamento");
        String dptName = in.nextLine();
        Departamento aux = departamentos.getDepartamentoByName(dptName);
        if(aux == null) return false;
        return funcionarios.add(new Funcionario(matricula, nome, aux));
    } //implementar deve ser facil

    // cadastrar uns departamentos, quem sabe usar enum
    private void novoRegistroDeCusto() {}; // implementar,
    private void pesquisarRegistro() {}; //  impementar esse eu realmnente n tenho ideia
    private void excluirRegistroDeCusto() {}; // implemnetar deve ser fascil, pensei em colocar na pesqisa de registro
    public void exibirPainel(){
        System.out.println("\n");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                        PAINEL DE DADOS                                |");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| FUNCIONARIO ATUALMENTE LOGADO: "+usuario.getNome()+"                                  \n" +            //placeholders inseridos
                           "| VALOR TOTAL DOS CUSTOS DO MÊS ATUAL: R$3000,00                                             \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE T.I.: R$2000,00                      \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE R.H.: R$100,00                       \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. FINANCEIRO: R$1,00                      \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. ADMINISTRATIVO: R$99,00                \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE MARKETING: R$0,00                    \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE ENGENHARIA: R$400,00                    \n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE VENDAS: R$400,00                        \n" +
                           "| OS 3 FUNCIONARIOS COM A MAIOR SOMA DE CUSTOS: Carlos, Roberto e Juliana                                        ");
        System.out.println("+---------------------------------------------------------------------------------------+\n\n");
    } // esse eu fiz
    private void novaFuncionalidade1() {}; // implementar, hehe
    private void novaFuncionalidade2() {}; // implementar, hehe2


    public void executar(){
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Digite seu nome de usuário para continuar: ");
        usuario.setNome(in.nextLine());
        System.out.println("Login efetuado com succeso!");
        System.out.println("Por favor, digite uma opção: ");
        selecao();
        opcao = in.nextInt();
        do {
            switch (opcao) {

                case 1:
                    listarFuncionarios();  //implementar
                    break;
                case 2:
                    registraFuncionario();        //implementar
                    break;
                case 3:
                    novoRegistroDeCusto();             //implementar
                    break;
                case 4:
                    pesquisarRegistro();          //implementar
                    excluirRegistroDeCusto();
                    break;
                case 5:
                    exibirPainel();              //implementar
                    break;
                case 6:
                    novaFuncionalidade1();             //implementar
                    break;
                case 7:
                    novaFuncionalidade2();           //implementar
                    break;
                default:
                    System.out.println("FALHA" + "\n" + "Por favor, insira uma opção válida.");  //implementar
                    opcao = in.nextInt();
                    break;

            }
        } while (opcao != 0);
    }
    /*public void inicializaDepartamentos(){           esse bixo ta inutil por enquanto
        Rh aux = new Rh("Recursos Humanos");
        departamentos.getDepartamentos().add(aux);
    }*/
    }
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