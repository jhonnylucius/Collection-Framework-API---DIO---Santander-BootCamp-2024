package carrinhoDeCompra;

public class Itens {
    private String descricao;
    private int quantidade;
    private double preco;

    // Construtor que recebe descrição, quantidade e preço
    public Itens(String descricao, int quantidade, double preco) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters para acessar os atributos
    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}