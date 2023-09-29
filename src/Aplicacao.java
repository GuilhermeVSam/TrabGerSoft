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
    private void listarFuncionarios () {};
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
    }
    // cadastrar uns departamentos, quem sabe usar enum
    private boolean novoRegistroDeCusto() {return true;};
    private void pesquisarRegistro() {};
    private void excluirRegistroDeCusto() {};
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
    }
    private void novaFuncionalidade1() {};
    private void novaFuncionalidade2() {};


    public void executar(){
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Digite seu nome de usuário para continuar: ");
        usuario.setNome(in.nextLine());
        System.out.println("Login efetuado com succeso!");
        System.out.println("Por favor, digite uma opção: ");
        do {
            switch (opcao) {

                case 1:
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    break;
                case 8:
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    break;

                default:
                    System.out.println("FALHA" + "\n" + "Por favor, insira uma opção válida.");
                    opcao = in.nextInt();
                    break;

            }
        } while (opcao != 0);
        //exibirPainel();
        //System.out.println("Login efetuado com sucesso");           Ainda n funciona, o login deveria retornar um true quando funciona ou algo do tipo n sei
        //registraFuncionario();
        //System.out.println(funcionarios.listarFuncionarios());
        //System.out.println(departamentos.listarDepartamentos());

    }
    public void inicializaDepartamentos(){
        Rh aux = new Rh("Recursos Humanos");
        departamentos.getDepartamentos().add(aux);
    }
}
