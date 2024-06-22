package carrinhoDeCompra;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {
    private List<Itens> itensList; // lista para armazenar os itens 
    private List<Itens> itensRemovidos; // Lista para armazenar itens removidos

    public CarrinhoDeCompras() {
        this.itensList = new ArrayList<>(); // inicializa a lista itens
        this.itensRemovidos = new ArrayList<>(); // Inicializa a lista de itens removidos
    }

    public void adicionarItens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a descrição do item: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o preço unitário do item: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite a quantidade do item: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        itensList.add(new Itens(descricao, quantidade, preco)); // Cria um objeto Itens e adiciona à lista
    }

    // Remover todas as ocorrências de itens com a descrição fornecida
    public void removerItens(String descricao) {
        for (int i = itensList.size() - 1; i >= 0; i--) { // Iterar de trás para frente para remover com segurança
            if (itensList.get(i).getDescricao().equalsIgnoreCase(descricao)) {
                itensRemovidos.add(itensList.remove(i)); // Adiciona à lista de itens removidos e remove da lista principal
            }
        }
    }

    public int obterNumeroTotalItens() {
        return itensList.size();
    }

    // Imprimir as descrições dos itens
    public void obterDescricoesItens() {
        if (itensList.isEmpty()) {
            System.out.println("A lista de itens está vazia.");
        } else {
            double valorTotalLista = 0;
            for (int i = 0; i < itensList.size(); i++) {
                Itens item = itensList.get(i);
                double valorTotalItem = item.getPreco() * item.getQuantidade();
                System.out.println((i + 1) + ". " + item.getDescricao() + 
                        " - Quantidade: " + item.getQuantidade() + 
                        " - Preço Unitário: R$ " + String.format("%.2f", item.getPreco()) + 
                        " - Valor Total: R$ " + String.format("%.2f", valorTotalItem));
                valorTotalLista += valorTotalItem;
            }
            System.out.println("\nValor Total da Lista: R$ " + String.format("%.2f", valorTotalLista));
        }
    }

    // Imprimir as descrições dos itens removidos
    public void obterDescricoesItensRemovidos() {
        if (itensRemovidos.isEmpty()) {
            System.out.println("A lista de itens removidos está vazia.");
        } else {
            for (Itens i : itensRemovidos) {
                System.out.println(i.getDescricao() + " - Quantidade: " + i.getQuantidade() + 
                        " - Preço Unitário: R$ " + String.format("%.2f", i.getPreco()));
            }
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Crie uma instância do carrinho
        Scanner scanner = new Scanner(System.in); // abrir interação com uusuário pelo Scanner

        //  opções para o usuário escolher
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Listar Itens");
            System.out.println("4. Listar itens removidos"); 
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            //colocando um switch para fazer a interação com as opões escolhidas
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        carrinho.adicionarItens(); // Adiciona o item, pede as informações e volta ao menu
                        break;
                    case 2:
                        System.out.print("Digite a descrição do item a ser removido: ");
                        String descricaoRemover = scanner.nextLine();
                        carrinho.removerItens(descricaoRemover); // Utilize o objeto "carrinho"
                        break;
                    case 3:
                        System.out.println("\nItens:");
                        carrinho.obterDescricoesItens(); // Utilize o objeto "carrinho"
                        break;
                    case 4:
                        System.out.println("\nItens Removidos:");
                        carrinho.obterDescricoesItensRemovidos(); // Utilize o objeto "carrinho"
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return; // Sai do programa apenas se o usuário escolher a opção 4
                    default:
                        System.out.println("Por favor digite o nº da opção que você quer escolher.");
                }
                //tratamento da exeção caso não digite um número da opção corretamente
            } catch (InputMismatchException e) {
                System.out.println("Por favor digite o nº da opção que você quer escolher.");
                scanner.nextLine(); // Limpa o buffer de entrada
                
            }
           
        }
    }
}
