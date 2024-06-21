import java.util.ArrayList;
import java.util.List;

class Tarefa {
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

class ListaTarefas {
    private List<Tarefa> tarefas;

    public ListaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        tarefas.removeIf(tarefa -> tarefa.getDescricao().equals(descricao));
    }

    public int obterNumeroTotalTarefas() {
        return tarefas.size();
    }

    public List<String> obterDescricoesTarefas() {
        List<String> descricoes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            descricoes.add(tarefa.getDescricao());
        }
        return descricoes;
    }
}

public class ListaDeTarefas {
    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        lista.adicionarTarefa("Comprar pão");
        lista.adicionarTarefa("Estudar para a prova");

        System.out.println("Número total de tarefas: " + lista.obterNumeroTotalTarefas());  // Output: 2
        System.out.println("Descrições das tarefas: " + lista.obterDescricoesTarefas());   // Output: [Comprar pão, Estudar para a prova]

        lista.removerTarefa("Comprar pão");

        System.out.println("Pão comprado, retirando da lista.");
        System.out.println("Número total de tarefas: " + lista.obterNumeroTotalTarefas());  // Output: 1
        System.out.println("Descrições das tarefas: " + lista.obterDescricoesTarefas());   // Output: [Estudar para a prova]
    }
}

