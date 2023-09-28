package com.utils;

import com.departamentos.Departamento;

public class Custo {
    private double valor;
    private String descricao;
    private String data; // Talvez utilizar um objeto data?
    private Categorias categoria;
    private Departamento departamento;


    public Custo(double valor, String descricao, String data, Categorias categoria, Departamento departamento) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.departamento = departamento;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
