package carrinhoDeCompra;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class CarrinhoDeCompras {
    private List<Itens> itensList;
    private List<Itens> itensRemovidos;

    public CarrinhoDeCompras() {
        this.itensList = new ArrayList<>();
        this.itensRemovidos = new ArrayList<>();
    }

    public void adicionarItens(String descricao, int quantidade, double preco) {
        itensList.add(new Itens(descricao, quantidade, preco));
    }

    public void removerItens(String descricao) {
        for (int i = itensList.size() - 1; i >= 0; i--) {
            if (itensList.get(i).getDescricao().equalsIgnoreCase(descricao)) {
                itensRemovidos.add(itensList.remove(i));
            }
        }
    }

    public int obterNumeroTotalItens() {
        return itensList.size();
    }

    public void obterDescricoesItens(JTextArea area) {
        if (itensList.isEmpty()) {
            area.setText("A lista de itens está vazia.");
        } else {
            double valorTotalLista = 0;
            for (int i = 0; i < itensList.size(); i++) {
                Itens item = itensList.get(i);
                double valorTotalItem = item.getPreco() * item.getQuantidade();
                area.append((i + 1) + ". " + item.getDescricao() +
                        " - Quantidade: " + item.getQuantidade() +
                        " - Preço Unitário: R$ " + String.format("%.2f", item.getPreco()) +
                        " - Valor Total: R$ " + String.format("%.2f", valorTotalItem) + "\n");
                valorTotalLista += valorTotalItem;
            }
            area.append("\nValor Total da Lista: R$ " + String.format("%.2f", valorTotalLista));
        }
    }

    public void obterDescricoesItensRemovidos(JTextArea area) {
        if (itensRemovidos.isEmpty()) {
            area.setText("A lista de itens removidos está vazia.");
        } else {
            for (Itens i : itensRemovidos) {
                area.append(i.getDescricao() + " - Quantidade: " + i.getQuantidade() +
                        " - Preço Unitário: R$ " + String.format("%.2f", i.getPreco()) + "\n");
            }
        }
    }

    public List<Itens> getItensRemovidos() {
        return itensRemovidos;
    }
}