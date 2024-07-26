package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio10 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> imparesMultiplos3ou5 = numeros.stream()
                .filter(n -> n % 2 != 0 && (n % 3 == 0 || n % 5 == 0)) // Filtra os ímpares múltiplos de 3 ou 5
                .collect(Collectors.toList()); // Coleta os elementos filtrados em uma nova lista

        System.out.println("Valores ímpares múltiplos de 3 ou 5: " + imparesMultiplos3ou5);
    }
}