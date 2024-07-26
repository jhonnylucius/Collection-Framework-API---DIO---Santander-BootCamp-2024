package ganhandoProdStremAPI.functinal_interface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Representa uma operação que não aceita nenhum argumento e retorna um 
 * resultado do tipo T.(consumer não retorna nada)
 * É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
 */


public class SupplierExample {
  public static void main(String[] args) {
    
    Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!"; // Cria uma instância de Supplier chamada saudacao
     // que recebe uma expressão lambda que retorna a string "Olá, seja bem-vindo(a)!"

    // Cria um Stream infinito de strings usando o método generate,
    // que recebe uma expressão lambda que retorna a string "Olá e tchau"
    List<String> listaSaudacoes = Stream.generate(() -> "Olá flor do dia!") 
        .limit(3) // Limita o Stream a 3 elementos
        .toList(); // Coleta os elementos do Stream em uma lista
        

    // Itera sobre cada elemento da lista e imprime no console
    listaSaudacoes.forEach(System.out :: println); 
  }
}