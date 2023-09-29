package com.funcionarios;

import java.util.ArrayList;
public class Funcionarios {

    private ArrayList<Funcionario> funcionarios;

    public Funcionarios(){
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
        int i = 0;
        for (Funcionario funcionario : funcionarios) {
            aux += i + funcionario.toString() + "\n";
            i++;
        }
        return aux;
    }

    public Funcionario login(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean removerFuncionarioPorMatricula(String matricula) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getMatricula().equalsIgnoreCase(matricula)) {
                funcionarios.remove(i);
                return true;
            }
        }
        return false;
    }
}