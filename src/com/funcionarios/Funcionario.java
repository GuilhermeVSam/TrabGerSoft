package com.funcionarios;

import com.departamentos.Deptos;

public class Funcionario {
    private String matricula;
    private String nome;
    private Deptos departamento;

    public Funcionario(String matricula, String nome, Deptos departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
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

    @Override
    public String toString() {
        return "[Matricula: " + this.matricula + " - Nome: " + this.nome + " - Departamento: " + this.departamento.getNome() + "]";
    }
}
