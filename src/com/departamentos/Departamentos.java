package com.departamentos;

import java.util.ArrayList;

public class Departamentos {
    private ArrayList<Departamento> departamentos;

    public Departamentos(){
        this.departamentos = new ArrayList<>();
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Departamento getDepartamentoByName(String nome){
        for (Departamento dpt: departamentos
             ) {
            if(dpt.getNome().equalsIgnoreCase(nome)) return dpt;
        }
        return null;
    }
    public String listarDepartamentos(){
        String aux = "";
        for (Departamento dpt: departamentos){
            aux += dpt.getNome();
        }
        return aux;
    }
}
