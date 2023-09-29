package com.utils;

public enum Categorias {
    AQUISICAO("Aquisição"), MANUTENCAO("Manutenção"), OUTROS("Outros"); // podem ser criadas outras no futuro

    private String nome;

    Categorias(String descricao) {
        this.nome = descricao;
    }

    public String getNome() {
        return nome;
    }

    public static Categorias fromString(String str) {
        for (Categorias dep : Categorias.values()) {
            if (dep.nome.equalsIgnoreCase(str)) {
                return dep;
            }
        }
        return null;
    }
}


