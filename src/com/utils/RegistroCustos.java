package com.utils;
import com.departamentos.Departamentos;
import com.funcionarios.Funcionario;

import java.util.ArrayList;

public class RegistroCustos {
    private ArrayList<Custo> registroCustos;

    public RegistroCustos(){
        registroCustos = new ArrayList<>();
    }

    public ArrayList<Custo> getRegistroCustos(){
        return registroCustos;
    }
    public void registrarCustos(Custo custo){
        registroCustos.add(custo);
        System.out.println("Custo adicionado com sucesso.");
    }

    public void excluirCustoRecente(){
        if(!registroCustos.isEmpty()){
            registroCustos.remove(registroCustos.size() - 1);
            System.out.println("Custo mais recente removido com sucesso!");
        } else {
            System.out.println("Não há custos para excluir.");
        }
    }

    public double somaCustosPorMes(int mes) {
        double somaMesAtual = 0;

        for (Custo custo : registroCustos) {
            if (custo.getMes() == mes) {
                somaMesAtual += custo.getValor();
            }
        }
        return somaMesAtual;
    }

    public void mostrarCustoPorDep(Departamentos depto){
        
    }
}
