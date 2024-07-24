package conjuntoConvidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
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

    }

