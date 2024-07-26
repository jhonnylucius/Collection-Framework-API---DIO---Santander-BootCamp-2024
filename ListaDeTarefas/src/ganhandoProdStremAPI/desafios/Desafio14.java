package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio14 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int maiorPrimo = numeros.stream()
                .filter(Desafio14::isPrime) // Filtra os números primos
                .max(Integer::compareTo) // Encontra o maior número
                .orElseThrow(() -> new RuntimeException("A lista não contém números primos.")); // Lança uma exceção caso a lista não tenha primos

        System.out.println("O maior número primo é: " + maiorPrimo);
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