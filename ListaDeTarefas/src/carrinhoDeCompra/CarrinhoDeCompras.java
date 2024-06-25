
package carrinhoDeCompra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CarrinhoDeCompras {

    private Map<String, Item> itens;
    private List<Item> itensRemovidos;

    public CarrinhoDeCompras() {
        itens = new HashMap<>();
        itensRemovidos = new ArrayList<>();
    }

    public void adicionarItens(String descricao, int quantidade, double preco) {
        if (itens.containsKey(descricao)) {
            Item itemExistente = itens.get(descricao);
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
        } else {
            itens.put(descricao, new Item(descricao, quantidade, preco));
        }
    }

    public void removerItens(String descricao) {
        if (itens.containsKey(descricao)) {
            Item itemRemovido = itens.remove(descricao);
            itensRemovidos.add(itemRemovido);
        }
    }

    public int obterNumeroTotalItens() {
        return itens.size();
    }

    public void obterDescricoesItens(JTextArea area, JLabel valorTotalLabel) {
        if (itens.isEmpty()) {
            area.setText("A lista de itens está vazia.");
        } else {
            double valorTotalLista = 0;
            for (Item item : itens.values()) {
                double valorTotalItem = item.getPreco() * item.getQuantidade();
                area.append(item.getDescricao() + " - Quantidade: " + item.getQuantidade() +
                        " - Preço Unitário: R$ " + String.format("%.2f", item.getPreco()) +
                        " - Valor Total: R$ " + String.format("%.2f", valorTotalItem) + "\n");
                valorTotalLista += valorTotalItem;
            }
            area.append("\nValor Total da Lista: R$ " + String.format("%.2f", valorTotalLista));
            valorTotalLabel.setText("Valor Total: R$ " + String.format("%.2f", valorTotalLista)); // Atualiza o valor total
        }
    }

    public void obterDescricoesItensRemovidos(JTextArea area) {
        if (itensRemovidos.isEmpty()) {
            area.setText("A lista de itens removidos está vazia.");
        } else {
            for (Item item : itensRemovidos) {
                area.append(item.getDescricao() + " - Quantidade: " + item.getQuantidade() +
                        " - Preço Unitário: R$ " + String.format("%.2f", item.getPreco()) + "\n");
            }
        }
    }

    public List<Item> getItensRemovidos() {
        return itensRemovidos;
    }
}