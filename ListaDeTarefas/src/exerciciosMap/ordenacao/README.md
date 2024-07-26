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

### Melhorias que podem ser feitas no Código</br>

- Utilização de Streams e Lambdas (Java 8+):</br>

- Utilize streams e lambdas para tornar o código mais conciso e legível.</br>
Documentação e Comentários:</br>

- Adicione JavaDoc para classes e métodos, explicando o propósito e a lógica de cada um.</br>
Melhore os comentários no código, especialmente para partes complexas.</br>
</br>

1. Tratamento de Erros:</br>
</br>

2. Adicione tratamento de exceções adequado, como try-catch blocks para operações críticas.</br>

3. Adicione mensagens de erro amigáveis ao usuário.</br>

### Validações: </br>

1. Adicione validações para os métodos, por exemplo, verificar se o livro já existe antes de </br>adicionar e se o título é válido ao remover.</br>

## Testes Unitários:</br>

1. Adicione testes unitários usando frameworks como JUnit para garantir que as </br>funcionalidades estão corretas e evitar regressões.</br>
</br>

2. Separação de Responsabilidades:</br>
</br>

- Separe as responsabilidades em diferentes classes e pacotes, como uma</br> classe de serviço para a lógica de negócio e uma classe de repositório para operações de dados.</br>

## Melhorias Funcionais</br>

1. Interface Gráfica (GUI):</br>

- Desenvolva uma interface gráfica para a livraria usando JavaFX ou Swing para tornar a </br>aplicação mais amigável ao usuário.</br>

- Persistência de Dados:</br>

- Implemente persistência de dados usando arquivos, banco de dados ou serialização</br> para que os livros adicionados sejam salvos entre execuções.</br>

## Busca Avançada:</br>

- Adicione funcionalidades de busca avançada, como buscar por faixa de preço, </br>palavras-chave no título, etc.</br>
</br>

## Ordenação por Outros Critérios:</br>

- Permita ordenação por outros critérios, como data de publicação ou popularidade.</br>

-Internacionalização (i18n):</br>

- Adicione suporte para múltiplos idiomas para tornar a aplicação acessível </br>a um público mais amplo.
