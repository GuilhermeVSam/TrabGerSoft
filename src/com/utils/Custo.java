package com.utils;
import java.util.ArrayList;
import java.util.List;
import com.departamentos.Deptos;

public class Custo {
    private double valor;
    private String descricao;
    private String data; // Talvez utilizar um objeto data?
    private Categorias categoria;
    private Deptos departamento;
    private List<Comentario> comentarios;
    private String autor;


    public Custo(double valor, String descricao, String data, Categorias categoria, Deptos departamento, String autor) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.departamento = departamento;
        this.comentarios = new ArrayList<>();
        this.autor = autor;
    }

    public Custo(String descricao2, double valor2) {
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

    public int getMes() {
        try {
            String[] a = data.split("/");
            int aux = Integer.parseInt(a[1]);
            return aux;
        } catch (Exception e) {
            System.out.println("Data mal formtada");
            return -1;
       }
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public Deptos getDepartamento() {
        return departamento;
    }
     public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
     }
     public List<Comentario> listarComentarios() {
        return comentarios;
     }


    public Deptos mapearDepartamento(String departamentoEntrada) {
        try {
            return Deptos.valueOf(departamentoEntrada.toUpperCase()); 
        } catch (IllegalArgumentException e) {
            return null; 
        }
    }

    public String getAutor(){
        return autor;
    }
}
