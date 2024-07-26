package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio7 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> numerosOrdenados = numeros.stream()
                .sorted(Comparator.reverseOrder()) // Ordena a lista em ordem decrescente
                .distinct() // Remove elementos duplicados
                .collect(Collectors.toList()); // Coleta os elementos ordenados em uma nova lista

        if (numerosOrdenados.size() >= 2) {
            int segundoMaior = numerosOrdenados.get(1); // Obtém o segundo elemento da lista ordenada
            System.out.println("O segundo maior número é: " + segundoMaior);
        } else {
            System.out.println("A lista não possui pelo menos dois números distintos.");
        }
    }
}