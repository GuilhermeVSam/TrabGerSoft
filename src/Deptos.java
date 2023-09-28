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
}