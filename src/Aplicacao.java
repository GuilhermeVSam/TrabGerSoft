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

    public void executar(){
        System.out.println("Bem vindo ao sistema!");
        System.out.println("Digite seu nome de usuário para continuar: ");
        fun.listarFuncionarios();
        usr = fun.login(in.nextLine());
    }
}
