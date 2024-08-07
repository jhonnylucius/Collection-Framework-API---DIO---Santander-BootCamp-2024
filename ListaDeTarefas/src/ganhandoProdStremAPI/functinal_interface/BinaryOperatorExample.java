package ganhandoProdStremAPI.functinal_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
 * É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
 */
public class BinaryOperatorExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
    // BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2; (código com lambda)
    BinaryOperator<Integer> somar = Integer::sum;

    // Usar o BinaryOperator para somar todos os números no Stream
    int resultado = numeros.stream()
        .reduce(0, Integer::sum);
    // "identity é uma varíavel temporaria e incia com 0"(acima)    

    // Imprimir o resultado da soma
    System.out.println("A soma dos números é: " + resultado);
  }
}