package agendaContatos;

public class Contatos {
   
    // atributos
    private String nome;    
    private int telefone;
    
//a IDE cria pra os construtores, so clicar na lâmpada amarela e selecionar quais construtores quer
public Contatos(String nome, int telefone) {
    this.nome = nome;
    this.telefone = telefone;
}
    
    //a IDE cria os getters ou setters da mesma forma dos contrutores
    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;

    }


     //a IDE cria o equals hashCoder pra vc da mesma forma e cria a 
    //condição para vc, equals compara o conteúdo dos objetos.
    //hashCode abaixo fornece um código único para cada objeto (quase único).
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Contatos other = (Contatos) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    } 
   
   
    //A iDE cria o ToString para que saia correto a impressão dos testes e app
    @Override
    public String toString() {
        return "Contatos [nome=" + nome + ", telefone=" + telefone + "]";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




   
   
   
    }
