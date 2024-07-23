package operacoesbasicas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListaTarefa {
    private List<Tarefa> tarefaList;
    List<Tarefa> tarefasRemovidas; // Lista para armazenar tarefas removidas

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
        this.tarefasRemovidas = new ArrayList<>(); // Inicializa a lista de tarefas removidas
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    // Remover todas as ocorrências da tarefa com a descrição fornecida
    public void removerTarefa(String descricao) {
        for (int i = tarefaList.size() - 1; i >= 0; i--) { // Iterar de trás para frente para remover com segurança
            if (tarefaList.get(i).getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemovidas.add(tarefaList.remove(i)); // Adiciona à lista de removidas e remove da lista principal
            }
        }
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    // Imprimir as descrições das tarefas
    public void obterDescricoesTarefas() {
        if (tarefaList.isEmpty()) {
            System.out.println("A lista de tarefas está vazia.");
        } else {
            for (Tarefa t : tarefaList) {
                System.out.println(t.getDescricao());
            }
        }
    }

    // Imprimir as descrições das tarefas removidas
    public void obterDescricoesTarefasRemovidas() {
        if (tarefasRemovidas.isEmpty()) {
            System.out.println("A lista de tarefas removidas está vazia.");
        } else {
            for (Tarefa t : tarefasRemovidas) {
                System.out.println(t.getDescricao());
            }
        }
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        Scanner scanner = new Scanner(System.in);

        //  opções para o usuário escolher

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Listar Tarefas");
            System.out.println("4. Listar Tarefas Removidas"); // Nova opção para listar tarefas removidas
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
//colocando um switch para fazer a interação com as opões escolhidas3

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        listaTarefa.adicionarTarefa(descricao);
                        break;
                    case 2:
                        System.out.print("Digite a descrição da tarefa a ser removida: ");
                        String descricaoRemover = scanner.nextLine();
                        listaTarefa.removerTarefa(descricaoRemover);
                        break;
                    case 3:
                        System.out.println("\nTarefas:");
                        listaTarefa.obterDescricoesTarefas();
                        break;
                    case 4:
                        System.out.println("\nTarefas Removidas:");
                        listaTarefa.obterDescricoesTarefasRemovidas(); // Chama o método para listar tarefas removidas
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
