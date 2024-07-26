package ganhandoProdStremAPI.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio4 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0) // Filtra apenas os números pares
                .collect(Collectors.toList()); // Coleta os elementos filtrados em uma nova lista

        System.out.println("Lista com apenas números pares: " + numerosPares);
    }
}