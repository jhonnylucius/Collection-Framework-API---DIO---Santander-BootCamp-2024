package agendaContatos;

import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

public class AgendaContatos {

    //atributos
    private static Set<Contatos> contatosSet;
    // construtores
    public AgendaContatos(Set<Contatos> contatosSet) {
        AgendaContatos.contatosSet = new HashSet<>();
    }
    //criando método adicionarContatos
    public void adicionarContatos(String nome, int telefone) {
        contatosSet.add(new Contatos(nome, telefone));
    }
    //criando método removerContatos
    public void removerContatos(String nome) {
        Contatos contatosParaRemover = null;
        for (Contatos obj : contatosSet) {
            if (obj.getNome() == nome) {
                contatosParaRemover = obj;
                break;
            }
        }
        contatosSet.remove(contatosParaRemover);
    }
    public void exibirContatos() {
        if(!contatosSet.isEmpty()) {
            System.out.println(contatosSet);
        }else{
            System.out.println("O conjunto está vazio");
        }
    }

    public Set<Contatos> pesquisarPorNome(String nome) {
        Set<Contatos> contatosPorNome = new HashSet<>();
            if (!contatosSet.isEmpty()) {
                for(Contatos obj : contatosSet) {
                    if (obj.getNome().startsWith(nome)) {
                        contatosPorNome.add(obj);
            return contatosPorNome;
                    }
                }
                return contatosPorNome;
            } else { 
                throw new RuntimeErrorException(null, "O conjunto está vazio");
            } 
            
    }
    public Contatos atualizarTelefoneContato(String nome, int novoTelefone) {
        Contatos contatoAtualizado = null;
        if (!contatosSet.isEmpty()) {
          for (Contatos c : contatosSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
              c.setTelefone(novoTelefone);
              contatoAtualizado = c;
              break;
            }
          }
          return contatoAtualizado;
        } else {
          throw new RuntimeException("O conjunto está vazio!");
        }
      }
    
    public static void main(String[] args) {
        //instanciando a classe AgendaContatos
        AgendaContatos agendaContatos = new AgendaContatos(contatosSet);
        // exibindo contatos
        agendaContatos.exibirContatos();

        //adicionando contatos
        agendaContatos.adicionarContatos("Lucas", 349112401);
        agendaContatos.adicionarContatos("Laura", 333212401);
        agendaContatos.adicionarContatos("Lenísia", 345112401);
        agendaContatos.adicionarContatos("Luciano", 149112401);
        agendaContatos.adicionarContatos("Dio", 249112401);

        //exibindo contatos na agenda

        agendaContatos.exibirContatos();
          // Pesquisando contatos pelo nome
        System.out.println(agendaContatos.pesquisarPorNome("Lenísia"));

        // Atualizando o número de um contato
    Contatos contatoAtualizado = agendaContatos.atualizarTelefoneContato("Lucas", 44443333);
    System.out.println("Contato atualizado: " + contatoAtualizado);

    }
   
}








/*public class ConjuntoConvidados {
    //atributos
    private static Set<Convidados> convidadosSet;

    public ConjuntoConvidados(Set<Convidados> convidadosSet) {
        ConjuntoConvidados.convidadosSet = new HashSet<>();
    }

    public void adicionarConvidados(String nome, int numeroConvite ) {
        convidadosSet.add(new Convidados(nome, numeroConvite));
    }
    public void removerConvidadoPorNumeroConvite(int numeroConvite) {
        Convidados convidadoParaRemover = null;
        for(Convidados c : convidadosSet) {
            if (c.getNumeroConvite() == numeroConvite) {
                convidadoParaRemover = c;
                break;
            }
        }

        convidadosSet.remove(convidadoParaRemover);
        
    }    

    public static int contarConvidados() {
        return convidadosSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadosSet);
    }
public static void main(String[] args) {
    ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados(convidadosSet);
    System.out.println("Existem " + ConjuntoConvidados.contarConvidados() + " dentro do set de convidados");
// add o convidados
    conjuntoConvidados.adicionarConvidados("Lenísia", 0123);
    conjuntoConvidados.adicionarConvidados("Lucas", 0124);
    conjuntoConvidados.adicionarConvidados("Laura", 0125);
    conjuntoConvidados.adicionarConvidados("Luciano", 0123);
// exibe a lista de convidados, exibindo os convidados acima, só que um convite é clonado
// o set não aceita convite com msm codigo pela classe convidados usando
// equals and hashCode
    conjuntoConvidados.exibirConvidados();
        System.out.println("Existem " + ConjuntoConvidados.contarConvidados() + " dentro do set de convidados");
// removendo um convidado, note que ele remove a Lenísia, 
//e não o Luciano pois ele nem foi gravado, não sendo valido o sistema remove o codigo valido 
    conjuntoConvidados.removerConvidadoPorNumeroConvite(0123);
        System.out.println("Existem " + ConjuntoConvidados.contarConvidados() + " dentro do set de convidados");


}

    } */