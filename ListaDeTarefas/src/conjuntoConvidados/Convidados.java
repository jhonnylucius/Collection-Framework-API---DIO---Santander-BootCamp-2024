package conjuntoConvidados;

public class Convidados {
    //atributos
    private String nome;
    private int numeroConvite;
    
    public Convidados(String nome, int numeroConvite) {
        this.nome = nome;
        this.numeroConvite = numeroConvite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroConvite() {
        return numeroConvite;
    }

    public void setNumeroConvite(int numeroConvite) {
        this.numeroConvite = numeroConvite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroConvite;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Convidados other = (Convidados) obj;
        if (numeroConvite != other.numeroConvite)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Convidados [nome=" + nome + ", numeroConvite=" + numeroConvite + "]";
    }
    

}
