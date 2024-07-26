package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio13 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> numerosIntervalo = numeros.stream()
                .filter(n -> n >= 5 && n <= 10) // Filtra os números dentro do intervalo de 5 a 10
                .collect(Collectors.toList()); // Coleta os elementos filtrados em uma nova lista

        System.out.println("Números dentro do intervalo de 5 a 10: " + numerosIntervalo);
    }
}