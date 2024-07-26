package ganhandoProdStremAPI.desafios;


import java.util.Arrays;
import java.util.List;

public class Desafio5 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        double mediaMaioresQue5 = numeros.stream()
                .filter(n -> n > 5) // Filtra os números maiores que 5
                .mapToDouble(Integer::doubleValue) // Converte os inteiros para double
                .average() // Calcula a média dos valores
                .getAsDouble(); // Obtém o valor da média

        System.out.println("Média dos números maiores que 5: " + mediaMaioresQue5);
    }
}