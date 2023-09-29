package com.funcionarios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

import com.utils.Custo;

public class Funcionarios {

    private ArrayList<Funcionario> funcionarios;

    public Funcionarios() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public boolean add(Funcionario funcionario) {
        return this.funcionarios.add(funcionario);
    }

    public String listarFuncionarios() {
        return toString();
    }

    public Funcionario login(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        System.out.println("Nome de usuário inexistente.");
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

    public String getMaioresLancadores(){
        return "";
    }


    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        int i = 0;
        for (Funcionario funcionario : funcionarios) {
            aux.append(i).append(funcionario.toString()).append("\n");
            i++;
        }
        return aux.toString();
    }
}
