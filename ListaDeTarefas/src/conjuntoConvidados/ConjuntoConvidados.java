package conjuntoConvidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    //atributos
    private static Set<Convidados> convidadosSet;

    public ConjuntoConvidados(Set<Convidados> convidadosSet) {
        this.convidadosSet = new HashSet<>();
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

    conjuntoConvidados.adicionarConvidados("Lenísia", 0123);
    conjuntoConvidados.adicionarConvidados("Lucas", 0124);
    conjuntoConvidados.adicionarConvidados("Laura", 0125);
    conjuntoConvidados.adicionarConvidados("Luciano", 0123);

    conjuntoConvidados.exibirConvidados();
        System.out.println("Existem " + ConjuntoConvidados.contarConvidados() + " dentro do set de convidados");

    conjuntoConvidados.removerConvidadoPorNumeroConvite(0123);
        System.out.println("Existem " + ConjuntoConvidados.contarConvidados() + " dentro do set de convidados");


}

    }

