import java.util.Scanner;

public class Aplicacao {
    Scanner in;
    Funcionarios fun;
    Funcionario usr;

    Aplicacao(){
        in = new Scanner(System.in);
        fun = new Funcionarios();

        Funcionario f1 = new Funcionario("123", "João", Deptos.TI);
        Funcionario f2 = new Funcionario("456", "Maria", Deptos.VENDAS);
        Funcionario f3 = new Funcionario("789", "José", Deptos.RH);
        Funcionario f4 = new Funcionario("101", "Ana", Deptos.FINANCEIRO);
        Funcionario f5 = new Funcionario("112", "Carlos", Deptos.ADMINISTRATIVO);
        fun.add(f1);
        fun.add(f2);
        fun.add(f3);
        fun.add(f4);
        fun.add(f5);
    }
    public void exibirPainel(){
        System.out.println("\n");
        System.out.println("+----------------------------------------------------+");
        System.out.println("|                    PAINEL DE DADOS                 |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| FUNCIONARIO ATUALMENTE LOGADO:                   |\n" + //usr.getNome() ainda n pq usr ta bugado
                           "| VALOR TOTAL DOS CUSTOS DO MÊS ATUAL: "+ "        |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE T.I.: "+"           |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE R.H.: "+"  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. FINANCEIRO: "+"  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. ADMINISTRATIVO: "+"  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE MARKETING: "+"  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE ENGENHARIA: "+"  |\n" +
                           "| VALOR TOTAL DOS CUSTOS DOS ÚLTIMOS 3 MESES DO DEP. DE VENDAS: "+"  |\n" +
                           "| OS 3 FUNCIONARIOS COM A MAIOR SOMA DE CUSTOS: "+"  |\n" +
                           "| 99 - Sair                            |");
        System.out.println("+--------------------------------------+\n\n");
    }

    public void executar(){
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Digite seu nome de usuário para continuar: ");
        fun.listarFuncionarios();
        usr = fun.login(in.nextLine());
        System.out.println("Login efetuado com sucesso");
        exibirPainel();
    }
}
