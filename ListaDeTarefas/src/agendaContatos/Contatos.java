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

    //a IDE cria o equals hashCoder pra vc da mesma forma e cria a 
    //condição para vc, equals compara o conteúdo dos objetos.
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
    //hashCode abaixo fornece um código único para cada objeto (quase único).
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
/*
 * equals e hashCode no Java: Uma Explicação Simples
Em Java, equals e hashCode são métodos essenciais para comparar objetos e usá-los em coleções como HashMap e HashSet.
equals:
Função: Verifica se dois objetos têm o mesmo conteúdo, ou seja, se são logicamente iguais.
Implementação: Se não for sobrescrito, compara se os objetos são a mesma referência na memória.

Uso:

Comparar objetos em termos de seus valores.

Garantir a igualdade sem depender da localização na memória.

Procurar elementos em coleções que armazenam objetos (como listas e conjuntos).

hashCode:

Função: Gera um código inteiro (hash) que representa o objeto.
Implementação: Se não for sobrescrito, usa a localização do objeto na memória.

Uso:
Acelerar pesquisas em estruturas de dados como HashMap e HashSet.
Comparar objetos de forma rápida, mas não garante que objetos com o mesmo código hash 
sejam iguais.

Relação entre equals e hashCode:

Se dois objetos são iguais de acordo com equals, seus códigos hash devem ser iguais.
Se dois objetos têm o mesmo código hash, eles não são necessariamente iguais.
Sobrescrever hashCode é crucial ao sobrescrever equals para manter a consistência e 
garantir o bom funcionamento de estruturas de dados como HashMap e HashSet.

Em resumo:
equals compara o conteúdo dos objetos.
hashCode fornece um código único para cada objeto (quase único).
Ao usar equals, lembre-se de sempre sobrescrever hashCode para garantir a consistência.

Exemplo:
Imagine uma classe Pessoa com os atributos nome e idade. Se você sobrescrever equals 
para comparar o nome e idade, também precisa sobrescrever hashCode para garantir que
 pessoas com o mesmo nome e idade tenham o mesmo código hash.
 * 
 */