## Este projeto implementa um sistema simples de cadastro de produtos utilizando Java. O código foi desenvolvido no VS Code.

</br>
Objetivo:</br>
O sistema permite adicionar produtos com código, nome, preço e quantidade.</br> Os produtos podem ser exibidos ordenados por nome ou por preço.</br>
</br>
Tecnologias utilizadas:</br>
</br>
Java: Linguagem de programação utilizada.</br>
</br>
VS Code: IDE utilizada para desenvolvimento.</br>
</br>
HashSet e TreeSet: Estruturas de dados Java para armazenar e organizar produtos.</br>
</br>
Estrutura do projeto:</br>
</br>
O projeto é composto pelas seguintes classes:</br>
Produto.java: Define a classe Produto com os atributos e métodos para representar um produto.</br>
CadastroProdutos.java: Define a classe CadastroProdutos com os métodos para adicionar</br> produtos, exibir produtos por nome ou por preço.</br></br>
</br>
Como executar o projeto:</br>
</br>
Compilar o código: Abra o terminal ou prompt de comando e execute javac *.java </br>no diretório do projeto.</br>
</br>
Executar o programa: Execute java cadastroDeProduto.CadastroProdutos no terminal.</br>
</br>
Exemplo de uso:</br>
</br>
Ao executar o programa, serão adicionados 4 produtos ao cadastro:</br>
</br>
Smartphone (código: 1, preço: 1000, quantidade: 10)</br>
</br>
Notebook (código: 2, preço: 1500, quantidade: 5)</br>
</br>
Mouse (código: 1, preço: 30, quantidade: 20)</br>
</br>
Teclado (código: 4, preço: 50, quantidade: 15)</br>
</br>
O programa exibirá a lista de produtos no cadastro, seguido pelas listas de produtos </br>ordenadas por nome e por preço.</br>
Recursos adicionais:</br>
</br>
O código utiliza a classe HashSet para evitar duplicatas de produtos com o mesmo código.</br>
</br>
A classe TreeSet é utilizada para ordenar os produtos por nome e por preço.</br>
</br>
A classe ComparatorPorPreco implementa a interface Comparator para comparar produtos pelo </br>preço.</br>
</br>
Observações:</br>
</br>
O código é um exemplo simples e pode ser expandido para incluir funcionalidades adicionais,</br> como editar ou remover produtos.</br>
</br>
O código não inclui tratamento de erros para entrada de dados inválidos.</br>