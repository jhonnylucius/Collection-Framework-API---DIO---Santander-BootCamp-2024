# Agenda de Contatos com Map em Java

</br>
Este projeto implementa uma agenda de contatos simples utilizando a estrutura de dados Map em Java. A agenda permite adicionar, remover e exibir contatos, além de pesquisar o telefone de um contato pelo nome.</br>
</br>

## Objetivo:</br>

</br>
O objetivo do projeto é demonstrar o uso da estrutura Map para armazenar e organizar dados de contatos, onde cada contato é associado a um número de telefone.</br>
</br>

## Tecnologias utilizadas:</br>

</br>
IDE: VSCODE.</br>
</br>
Java: Linguagem de programação utilizada.</br>
</br>

HashMap: Implementação da interface Map utilizada para armazenar os contatos.</br>
</br>

## Estrutura do projeto: </br>

</br>

## O projeto é composto por uma única classe, AgendaContatos.java, que contém os seguintes métodos:</br>

### AgendaContatos(): Construtor da classe, inicializa um HashMap para armazenar os contatos.</br>

### adicionarContato(String nome, Integer telefone): Adiciona um novo contato à agenda, associando o nome ao número de telefone.</br>

</br>

### removerContato(String nome): Remove um contato da agenda pelo nome.</br>

</br>

### exibirContatos(): Exibe todos os contatos na agenda, mostrando nome e telefone de cada um.</br>

</br>

### pesquisarPorNome(String nome): Procura o número de telefone de um contato pelo nome e retorna o número, ou null se o contato não estiver na agenda.</br>

### Como executar o projeto:</br>

</br>
Compilar o código: Abra o terminal ou prompt de comando e execute javac AgendaContatos.java no diretório do projeto.
</br>
Executar o programa: Execute java AgendaContatos no terminal.
</br>

### Exemplo de uso:</br>

</br>
O programa principal main demonstra como usar as funções da classe AgendaContatos:
Cria uma instância da classe AgendaContatos.</br>
</br>
Adiciona três contatos à agenda: "lucas", "laura" e "luciano" com seus respectivos números de telefone.
</br>
Chama o método exibirContatos() para mostrar todos os contatos na agenda.
</br>
Chama o método pesquisarPorNome() para procurar o telefone de "lucas" e imprime o resultado.</br>
</br>

### Observações:</br>

</br>
O código é um exemplo simples e pode ser expandido para incluir funcionalidades adicionais, como:</br>
</br>
Editar informações de um contato.</br>
</br>
Salvar e carregar a agenda de um arquivo.
</br>
Implementar uma interface gráfica para interação com o usuário.
</br>
O código não inclui tratamento de erros para entradas inválidas.
</br>
### Recursos adicionais:
O código demonstra como usar a estrutura Map para armazenar dados associativos, onde uma</br> chave (nome do contato) é associada a um valor (número de telefone).</br>
</br>
O código utiliza a interface Map.Entry para iterar pelo HashMap e acessar as chaves e valores.</br>