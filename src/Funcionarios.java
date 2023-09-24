import java.util.ArrayList;

public class Funcionarios {

    private ArrayList<Funcionario> funcionarios;

    Funcionarios(){
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public boolean add(Funcionario funcionario){
        return this.funcionarios.add(funcionario);
    }

    public String listarFuncionarios(){
        return toString();
    }

    @Override
    public String toString() {
        String aux = "";
        for (Funcionario funcionario : funcionarios) {
            aux += funcionario.toString() + "\n";
        }
        return aux;
    }
}
