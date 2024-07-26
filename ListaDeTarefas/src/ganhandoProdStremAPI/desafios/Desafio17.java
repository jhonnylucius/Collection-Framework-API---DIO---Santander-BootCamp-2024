package ganhandoProdStremAPI.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio17 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> primos = numeros.stream()
                .filter(Desafio17::isPrime) // Filtra os números primos
                .collect(Collectors.toList()); // Coleta os elementos filtrados em uma nova lista

        System.out.println("Números primos: " + primos);
    }

    private static boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}