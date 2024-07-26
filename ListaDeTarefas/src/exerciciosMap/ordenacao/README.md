# Agenda de Eventos - Organize seus eventos com datas e detalhes!</br>

</br>
- Este projeto implementa uma agenda de eventos em Java, permitindo que você adicione eventos</br> com datas, nomes e descrições de atrações, além de exibir a agenda completa e</br> encontrar o próximo evento agendado.</br>
</br>

## Funcionalidades:</br>

</br>

1. Adicionar Eventos: Permite adicionar novos eventos à agenda, incluindo a data, o nome do </br>evento e a descrição da atração.</br>
</br>
2. Exibir Agenda: Exibe a agenda completa de eventos, ordenada por data, mostrando o nome do evento, a data e a descrição da atração. </br>
</br>
3. Obter Próximo Evento: Busca e exibe o próximo evento agendado na agenda, considerando a data atual.</br>

## Observações: </br>

1. A agenda de eventos é armazenada na memória durante a execução do programa.</br>

2. Os eventos não são persistidos em um arquivo, então os dados serão perdidos </br>ao finalizar a execução.</br>

3. O código utiliza a classe LocalDate da API de tempo do Java para representar datas.</br>

4. O código utiliza a classe TreeMap para ordenar os eventos por data.</br>

## Melhorias que podem ser feitas:</br>

1. Salvar e carregar a agenda de um arquivo para persistir os dados.</br>

2. Implementar a possibilidade de editar ou remover eventos da agenda.</br>
3. Criar uma interface gráfica para interação com a agenda, tornando-a mais amigável.</br>
4. Adicionar funcionalidades para gerenciar diferentes tipos de eventos, como eventos </br>recorrentes ou eventos com horários específicos.</br>

## Livraria Online</br>

- Este projeto implementa uma livraria online em Java, onde é possível adicionar,</br> remover, exibir e pesquisar livros. Os livros podem ser ordenados por preço</br> e autor, além de obter os livros mais caros e mais baratos.</br>

1. Estrutura do Projeto</br>
</br>

### Classes</br>

</br>

1. Livro: Representa um livro com título, autor e preço.</br> 
2. ComparatorPorPreco: Implementa a interface Comparator para comparar livros por preço.</br>
3. ComparatorPorAutor: Implementa a interface Comparator para comparar livros por autor.</br>
4. LivrariaOnline: Implementa a lógica da livraria, como adicionar, remover, exibir, </br>ordenar e pesquisar livros.</br>

### Funcionalidades</br>

1. Adicionar Livro: Adiciona um livro ao mapa de livros.</br>
2. Remover Livro: Remove um livro do mapa de livros pelo título.</br>
3. Exibir Livros Ordenados por Preço: Exibe os livros ordenados pelo preço.</br>
4. Exibir Livros Ordenados por Autor: Exibe os livros ordenados pelo autor.</br>
5. Pesquisar Livros por Autor: Pesquisa livros pelo nome do autor.</br>
6. Obter Livro Mais Caro: Obtém o(s) livro(s) mais caro(s).</br>
7. Obter Livro Mais Barato: Obtém o(s) livro(s) mais barato(s).</br>

### Exemplo de Uso</br>

1. Adicione livros à livraria online.</br>
2. Exiba todos os livros ordenados por preço.</br>
3. Exiba todos os livros ordenados por autor.</br>
4. Pesquise livros por autor.</br>
5. Obtenha e exiba o livro mais caro.</br>
6. Obtenha e exiba o livro mais barato.</br>
7. Remova um livro pelo título e exiba a lista atualizada de livros.</br>
</br>

