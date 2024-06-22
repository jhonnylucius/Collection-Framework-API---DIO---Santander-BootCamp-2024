package operacoesbasicas;

public class Itens {
    private String descricao;
    private Double preco;
    private int quantidade;
    
    

    public Itens(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public Itens(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }
    public Itens(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
  
    }
