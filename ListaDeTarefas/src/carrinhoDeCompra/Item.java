package carrinhoDeCompra;

public class Item {
    private String descricao;
    private int quantidade;
    private double preco;

    // Construtor que recebe descrição, quantidade e preço
    public Item(String descricao, int quantidade, double preco) {
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

    // Método para definir a quantidade (para atualizar a quantidade no carrinho)
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getQuant() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuant'");
    }
}