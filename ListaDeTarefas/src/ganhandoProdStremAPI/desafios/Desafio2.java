package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio2 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int somaPares = numeros.stream()
                .filter(n -> n % 2 == 0) // Filtra apenas os números pares
                .reduce(0, Integer::sum); // Reduz a lista à soma dos elementos

        System.out.println("Soma dos números pares: " + somaPares);
    }
}