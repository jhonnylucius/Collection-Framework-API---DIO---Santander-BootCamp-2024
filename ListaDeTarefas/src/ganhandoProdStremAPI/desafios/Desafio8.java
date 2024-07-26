package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio8 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int somaDigitos = numeros.stream()
                .mapToInt(Desafio8::somaDigitos) // Mapeia cada número para a soma de seus dígitos
                .sum(); // Reduz a lista à soma dos elementos

        System.out.println("Soma dos dígitos de todos os números: " + somaDigitos);
    }

    private static int somaDigitos(int numero) {
        int soma = 0;
        while (numero > 0) {
            soma += numero % 10; // Soma o último dígito do número
            numero /= 10; // Remove o último dígito do número
        }
        return soma;
    }
}