## Este projeto implementa um sistema simples de cadastro de produtos utilizando Java. O código foi desenvolvido no VS Code.

</br>
Objetivo:</br>
O sistema permite adicionar produtos com código, nome, preço e quantidade.</br> Os produtos podem ser exibidos ordenados por nome ou por preço.</br>
Tecnologias utilizadas:</br>
Java: Linguagem de programação utilizada.</br>
VS Code: IDE utilizada para desenvolvimento.</br>
HashSet e TreeSet: Estruturas de dados Java para armazenar e organizar produtos.</br>
Estrutura do projeto:</br>
O projeto é composto pelas seguintes classes:</br>
Produto.java: Define a classe Produto com os atributos e métodos para representar um produto.</br>
CadastroProdutos.java: Define a classe CadastroProdutos com os métodos para adicionar</br> produtos, exibir produtos por nome ou por preço.</br></br>
Como executar o projeto:</br>
Compilar o código: Abra o terminal ou prompt de comando e execute javac *.java </br>no diretório do projeto.</br>
Executar o programa: Execute java cadastroDeProduto.CadastroProdutos no terminal.</br>
Exemplo de uso:</br>
Ao executar o programa, serão adicionados 4 produtos ao cadastro:</br>
Smartphone (código: 1, preço: 1000, quantidade: 10)</br>
Notebook (código: 2, preço: 1500, quantidade: 5)</br>
Mouse (código: 1, preço: 30, quantidade: 20)</br>
Teclado (código: 4, preço: 50, quantidade: 15)</br>
O programa exibirá a lista de produtos no cadastro, seguido pelas listas de produtos </br>ordenadas por nome e por preço.</br>
Recursos adicionais:</br>
O código utiliza a classe HashSet para evitar duplicatas de produtos com o mesmo código.</br>
A classe TreeSet é utilizada para ordenar os produtos por nome e por preço.</br>
A classe ComparatorPorPreco implementa a interface Comparator para comparar produtos pelo </br>preço.</br>
Observações:</br>
O código é um exemplo simples e pode ser expandido para incluir funcionalidades adicionais,</br> como editar ou remover produtos.</br>
O código não inclui tratamento de erros para entrada de dados inválidos.</br>