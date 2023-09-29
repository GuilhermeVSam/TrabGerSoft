package com.departamentos;
import com.funcionarios.Funcionarios;
import com.funcionarios.Funcionario;
import com.utils.Custo;

import java.util.ArrayList;

public abstract class Departamento{
    private String nome;
    private Funcionarios funcionarios;
    private ArrayList<Custo> custos;

    public ArrayList<Custo> getCustos() {
        return custos;
    }

    public void setCustos(ArrayList<Custo> custos) {
        this.custos = custos;
    }

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new Funcionarios();
        this.custos = new ArrayList<>();
    }

    public String getNome(){
        return this.nome;
    }

    public boolean registraFuncionario(Funcionario funcionario){
        return this.funcionarios.add(funcionario);
    }

    public static Departamento valueOf(String departamentoEntrada) {
        return null;
    }

}
