package com.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.departamentos.Departamento;

public class Custo {
    private double valor;
    private String descricao;
    private String data; // Talvez utilizar um objeto data?
    private Categorias categoria;
    private Departamento departamento;
    private List<Comentario> comentarios;


    public Custo(double valor, String descricao, String data, Categorias categoria, Departamento departamento) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.departamento = departamento;
        this.comentarios = new ArrayList<>();
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

    public Categorias getCategoria() {
        return categoria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
     public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
     }
     public List<Comentario> listarComentarios() {
        return comentarios;
     }

    public void registrarCustos(){
        Scanner tec = new Scanner(System.in);

        System.out.println("Informe o valor do custo: ");
        valor = tec.nextDouble();

        System.out.println("Informe a descrição do custo: ");
        descricao = tec.nextLine();

        System.out.println("Informe a data do custo: ");
        data = tec.nextLine();

        System.out.println("Informe a categoria do custo(AQUISIÇÃO, MANUTENÇÃO, OUTROS): ");
        String categoriaEntrada = tec.nextLine();
        Categorias categoria = Categorias.valueOf(categoriaEntrada);

        System.out.println("Informe o departamento do custo: ");
        String departamentoEntrada = tec.nextLine();

        Custo novoCusto = new Custo(valor, descricao, data, categoria, departamento);

        ArrayList<Custo> custos = departamento.getCustos();
        custos.add(novoCusto);
        departamento.setCustos(custos);
        System.out.println("Custo adicionado com sucesso.");

    }

    public void excluirCustoRecente(){
        ArrayList<Custo> registroCustos = departamento.getCustos();
        if(!registroCustos.isEmpty()){
            registroCustos.remove(registroCustos.size() - 1);
            System.out.println("Custo mais recente removido com sucesso!");
        } else {
            System.out.println("Não há custos para excluir.");
        }
    }



     
}
