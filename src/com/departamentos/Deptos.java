package com.departamentos;

public enum Deptos {
    TI("TI"),
    RH("RH"),
    FINANCEIRO("Financeiro"),
    ADMINISTRATIVO("Administrativo"),
    MARKETING("Marketing"),
    ENGENHARIA("Engenharia"),
    VENDAS("Vendas");

    private String nome;

    Deptos(String descricao) {
        this.nome = descricao;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Retorna um departamento a partir de uma string
     * @return
     */
    public static Deptos fromString(String str) {
        for (Deptos dep : Deptos.values()) {
            if (dep.nome.equalsIgnoreCase(str)) {
                return dep;
            }
        }
        return null;
    }
}
