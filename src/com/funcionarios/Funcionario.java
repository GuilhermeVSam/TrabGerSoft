package com.funcionarios;

import com.departamentos.Deptos;
import com.utils.Custo;

public class Funcionario implements Comparable<Funcionario> {
    private String matricula;
    private String nome;
    private Deptos departamento;
    private double somaCustos;

    public Funcionario(String matricula, String nome, Deptos departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        this.somaCustos = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        if (nome == null) {
            return "";
        } else {
            return nome;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Deptos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Deptos departamento) {
        this.departamento = departamento;
    }

    public void somaCusto(Custo custo){
        this.somaCustos += custo.getValor();
    }

    public double getSomaCustos(){
        return this.somaCustos;
    }

    @Override
    public int compareTo(Funcionario outro) {
        return (int) (somaCustos - outro.somaCustos);
    }

    @Override
    public String toString() {
        return "[Matricula: " + this.matricula + " - Nome: " + this.nome + " - Departamento: " + this.departamento.getNome() + "]";
    }
}
