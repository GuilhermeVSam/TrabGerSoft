public class Custos {
    private double valor;
    private String descricao;
    private String data; // Talvez utilizar um objeto data?
    private String categoria; // Talvez utilizar enum?
    private Departamento departamento;


    public Custos(double valor, String descricao, String data, String categoria, Departamento departamento) {
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

    public String getCategoria() {
        return categoria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
