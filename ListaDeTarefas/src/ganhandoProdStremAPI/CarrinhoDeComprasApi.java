package ganhandoProdStremAPI;


import java.util.ArrayList;
import java.util.List;

import carrinhoDeCompra.Item;
/*
//forma imperativa de escrever o código abaixo
public class CarrinhoDeComprasApi {
    //atributos
    private List<Item> itemList;
    //construtor
    public CarrinhoDeComprasApi() {
      this.itemList = new ArrayList<>();
    }
    
    //método para calcular valor total dos itens sem utilizar o Stream API
    public double calcularValorTotal() {
      double valorTotal = 0d;
      if (!itemList.isEmpty()) {
        for (Item item : itemList) {
          double valorItem = item.getPreco() * item.getQuant();
          valorTotal += valorItem;
        }
        return valorTotal;
      } else {
        throw new RuntimeException("A lista está vazia!");
      }
    }
  }

  */

  // forma funcional de escrever o mesmo codigo, usando a STREAM API
  // o código fica mauito mais resumido trazendo grande ganho de tempo de produção
  /// forma funcional abaixo do mesmo códifo

  public class CarrinhoDeComprasApi {
    //atributos
    private List<Item> itemList;
    //construtor
    public CarrinhoDeComprasApi() {
      this.itemList = new ArrayList<>();
    }
    
    //método para calcular valor total dos itens utilizando o Stream API
    public double calcularValorTotal() {
      if (itemList.isEmpty()) {
        throw new RuntimeException("A lista está vazia!");
      }
      return itemList.stream()
          .mapToDouble(item -> item.getPreco() * item.getQuant())
          .sum();
    }
  }