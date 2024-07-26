package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio19 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int somaDivisiveis = numeros.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0) // Filtra os números divisíveis por 3 e 5
                .reduce(0, Integer::sum); // Reduz a lista à soma dos elementos

        System.out.println("Soma dos números divisíveis por 3 e 5: " + somaDivisiveis);
    }
}