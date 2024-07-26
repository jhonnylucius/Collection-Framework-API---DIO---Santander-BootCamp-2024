package ganhandoProdStremAPI;

import java.util.ArrayList;
import java.util.List;

import ordenacaoPessoas.Pessoa; // Importa a classe Pessoa do pacote ordenacaoPessoas

public class OrdenacaoPessoa {
    //atributo
    private List<Pessoa> pessoaList; // Declara um atributo privado chamado pessoaList, que é uma lista de objetos Pessoa

    //construtor
    public OrdenacaoPessoa() { // Construtor da classe OrdenacaoPessoa
      this.pessoaList = new ArrayList<>(); // Inicializa a lista pessoaList com uma nova lista ArrayList
    }

    public List<Pessoa> ordenarPorAltura() { // Método para ordenar a lista de pessoas por altura
      if (!pessoaList.isEmpty()) { // Verifica se a lista pessoaList não está vazia
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList); // Cria uma nova lista chamada pessoasPorAltura, copiando os elementos de pessoaList
        pessoasPorAltura.sort((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura())); // Ordena a lista pessoasPorAltura usando o método sort,
      // que compara a altura de duas pessoas (p1 e p2) usando o método Double.compare
     // e retorna uma lista ordenada por altura
        return pessoasPorAltura; // Retorna a lista ordenada por altura
      } else {
        throw new RuntimeException("A lista está vazia!"); // Lança uma exceção RuntimeException se a lista estiver vazia
      }
    }
  }