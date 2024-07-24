package agendaContatos;

public class Contatos {
    // atributos
    String nome;
    int telefone;
    String emailString; 
//a IDE cria pra os construtores, so clicar na lâmpada amarela e selecionar quais construtores quer
    public Contatos(String nome, int telefone, String emailString) {
        this.nome = nome;
        this.telefone = telefone;
        this.emailString = emailString;
    }

    //a IDE cria o equals hashCoder pra vc da mesma forma e cria a condição para vc
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    
    //a IDE cria os getters ou setters da mesma forma dos contrutores
    public String getNome() {
        return nome;
    }
    public int getTelefone() {
        return telefone;
    }
    public String getEmailString() {
        return emailString;
    }
    //A iDE cria o ToString para que saia correto a impressão dos testes e app
    @Override
    public String toString() {
        return "Contatos [nome=" + nome + ", telefone=" + telefone + ", emailString=" + emailString + "]";
    }
   
   
    }
