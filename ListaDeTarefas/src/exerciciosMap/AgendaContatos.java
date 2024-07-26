package exerciciosMap;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    // atributos
    private Map<String, Integer> agendaContatosMap;

    // pela IDE crie os construtores
    public AgendaContatos() {
        this.agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatosMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatosMap.isEmpty()) {
            agendaContatosMap.remove(nome);
        }
    }

    // Exibe os contatos de forma organizada
    public void exibirContatos() {
        if (!agendaContatosMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : agendaContatosMap.entrySet()) {
                System.out.println("Nome: " + entry.getKey() + ", Telefone: " + entry.getValue());
            }
        } else {
            System.out.println("A agenda está vazia.");
        }
    }

    // Metodo de pesquisa o número se a agenda não estiver vazia
    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatosMap.isEmpty()) {
            numeroPorNome = agendaContatosMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("lucas", 367985467);
        agendaContatos.adicionarContato("laura", 323165455);
        agendaContatos.adicionarContato("luciano", 349245223);

        agendaContatos.exibirContatos(); // Exibe os contatos

        //agendaContatos.removerContato("Luciano");
        //agendaContatos.exibirContatos();
        // adicionado uma pesquisa
        // Exemplo de pesquisa
        Integer telefoneLucas = agendaContatos.pesquisarPorNome("lucas");
        if (telefoneLucas != null) {
            System.out.println("O telefone de Lucas é: " + telefoneLucas);
        } else {
            System.out.println("Lucas não está na agenda.");
        }
    }
}