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
    Funcionario usuario;
    Departamentos departamentos;

    Aplicacao(){
        in = new Scanner(System.in);
        funcionarios = new Funcionarios();
        departamentos = new Departamentos();

    }
    public void exibirPainel(){
        System.out.println("\n");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|                                   PAINEL DE DADOS                                     |");
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| FUNCIONARIO ATUALMENTE LOGADO: " + usr.getNome() + "                                 |\n" +
                           "| VALOR TOTAL DOS CUSTOS DO MÊS ATUAL: "+ "                                           |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE T.I.: "+"                     |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE R.H.: "+"                     |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. FINANCEIRO: "+"                  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. ADMINISTRATIVO: "+"              |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE MARKETING: "+"                |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE ENGENHARIA: "+"               |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE VENDAS: "+"                   |\n" +
                           "| OS 3 FUNCIONARIOS COM A MAIOR SOMA DE CUSTOS: "+"                                   |\n" +
                           "| 99 - Sair                                                                             |");
        System.out.println("+-----------------------------------------------------------------------------------+\n\n");
    }

    public void executar(){
        inicializaDepartamentos();
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Digite seu nome de usuário para continuar: ");
        funcionarios.listarFuncionarios();
        usuario = funcionarios.login(in.nextLine());
        System.out.println("Login efetuado com sucesso");
        registraFuncionário();
        System.out.println(funcionarios.listarFuncionarios());
        System.out.println(departamentos.listarDepartamentos());

    }

    public boolean registraFuncionário(){
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

    public void inicializaDepartamentos(){
        Rh aux = new Rh("Recursos Humanos");
        departamentos.getDepartamentos().add(aux);
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
}
