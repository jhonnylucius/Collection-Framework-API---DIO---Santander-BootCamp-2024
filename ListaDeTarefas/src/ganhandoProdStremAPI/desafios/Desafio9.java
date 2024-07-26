package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio9 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        boolean todosDistintos = numeros.stream()
                .distinct() // Remove elementos duplicados
                .count() == numeros.size(); // Verifica se a quantidade de elementos distintos é igual à quantidade original

        System.out.println("Todos os números são distintos? " + todosDistintos);
    }
}