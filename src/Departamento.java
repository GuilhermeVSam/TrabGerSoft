public abstract class Departamento{
    private String nome;
    private Funcionarios funcionarios;
    private Custos custos;

    public String getNome(){
        return this.nome;
    }

    public boolean registraFuncionario(Funcionario funcionario){
        return this.funcionarios.add(funcionario);
    }

}