package ordenacaoPessoas;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
  //atributo
  private List<Pessoa> pessoaList;

  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public void adicionarPessoa(String nome, int idade, double altura) {
    pessoaList.add(new Pessoa(nome, idade, altura));
  }

  public List<Pessoa> ordenarPorIdade() {
    List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
    if (!pessoaList.isEmpty()) {
      Collections.sort(pessoasPorIdade);
      return pessoasPorIdade;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public List<Pessoa> ordenarPorAltura() {
    List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
    if (!pessoaList.isEmpty()) {
      Pessoa pessoa = new Pessoa(null, 0, 0);      
      Collections.sort(pessoasPorAltura, pessoa.new ComparetorPorAltura());
      return pessoasPorAltura;
    }
    return pessoasPorAltura; 
    
  }

  public static void main(String[] args) {
  // Criando uma instância da classe OrdenacaoPessoas
    OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

    // Adicionando pessoas à lista
    ordenacaoPessoa.adicionarPessoa("Alice", 20, 1.56);
    ordenacaoPessoa.adicionarPessoa("Bob", 30, 1.80);
    ordenacaoPessoa.adicionarPessoa("Charlie", 25, 1.70);
    ordenacaoPessoa.adicionarPessoa("David", 17, 1.56);

    // Exibindo a lista de pessoas adicionadas
    System.out.println(ordenacaoPessoa.pessoaList);

    // Ordenando e exibindo por idade
    System.out.println(ordenacaoPessoa.ordenarPorIdade());

    // Ordenando e exibindo por altura
    System.out.println(ordenacaoPessoa.ordenarPorAltura());
  }
}