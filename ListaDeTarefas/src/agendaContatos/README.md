## equals e hashCode em Java: Uma Explicação Simples
<div>
Em Java, equals e hashCode são métodos essenciais para comparar objetos e usá-los em coleções como HashMap e HashSet.</br>
equals:</br>
Função: Verifica se dois objetos têm o mesmo conteúdo, ou seja, se são logicamente iguais.</br>
Implementação: Se não for sobrescrito, compara se os objetos são a mesma referência na memória.</br>

## Uso:</br>
Comparar objetos em termos de seus valores.</br>
Garantir a igualdade sem depender da localização na memória.</br>
Procurar elementos em coleções que armazenam objetos (como listas e conjuntos).</br>
## hashCode:</br>

## Função Gera um código inteiro (hash) que representa o objeto.</br>

Implementação: Se não for sobrescrito, usa a localização do objeto na memória.</br>

## Uso</br>

Acelerar pesquisas em estruturas de dados como HashMap e HashSet.</br>
Comparar objetos de forma rápida, mas não garante que objetos com o</br>mesmo código hash sejam iguais.</br>

## Relação entre equals e hashCode:</br>

<p></br>Se dois objetos são iguais de acordo com equals, seus códigos hash devem ser iguais.</br>
Se dois objetos têm o mesmo código hash, eles não são necessariamente iguais.</br>
Sobrescrever hashCode é crucial ao sobrescrever equals para manter a consistência e garantir </br>o bom funcionamento de estruturas de dados como HashMap e HashSet.</p></br>

## resumo 
equals compara o conteúdo dos objetos.</br>
hashCode fornece um código único para cada objeto (quase único).</br>
Ao usar equals, lembre-se de sempre sobrescrever hashCode para garantir a consistência.</br></br>
## Exemplo 
</br>
Imagine uma classe Pessoa com os atributos nome e idade. Se você sobrescrever equals para comparar o nome e idade, também precisa sobrescrever hashCode para garantir que pessoas com o mesmo nome e idade tenham o mesmo código hash.
</div>
