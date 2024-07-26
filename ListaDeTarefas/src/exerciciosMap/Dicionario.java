package exerciciosMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dicionario {

    // Atributo para armazenar o dicionário (HashMap)
    private Map<String, String> dicionario;

    // Construtor da classe Dicionário, inicializa o dicionário como um HashMap
    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    // Método para adicionar uma nova palavra e definição ao dicionário
    // Verifica se a palavra já existe, se a definição é válida e se o dicionário está vazio
    public void adicionarPalavra(String palavra, String definicao) {
        if (palavra.isEmpty() || definicao.isEmpty()) {
            System.out.println("Palavra e definição não podem ser vazias.");
            return;
        }
        if (dicionario.containsKey(palavra)) {
            System.out.println("Palavra já existe no dicionário.");
            return;
        }
        if (dicionario.isEmpty()) {
            System.out.println("Adicionando a primeira palavra ao dicionário...");
        }
        dicionario.put(palavra, definicao);
        System.out.println("Palavra '" + palavra + "' adicionada com sucesso.");
    }

    // Método para remover uma palavra do dicionário
    // Verifica se o dicionário está vazio e remove a palavra, caso exista
    public void removerPalavra(String palavra) {
        if (!dicionario.isEmpty()) {
            if (dicionario.containsKey(palavra)) {
                dicionario.remove(palavra);
                System.out.println("Palavra '" + palavra + "' removida com sucesso.");
            } else {
                System.out.println("Palavra não encontrada no dicionário.");
            }
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    // Método para pesquisar a definição de uma palavra
    // Retorna a definição da palavra, caso encontrada, ou uma mensagem de erro
    public String pesquisarPorPalavra(String palavra) {
        String definicao = dicionario.get(palavra);
        if (definicao != null) {
            return definicao;
        }
        return "Palavra não encontrada no dicionário.";
    }

    // Método para exibir todas as palavras e definições do dicionário
    // Verifica se o dicionário está vazio e imprime as palavras e definições
    public void exibirPalavras() {
        if (!dicionario.isEmpty()) {
            System.out.println(dicionario);
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    // Método para organizar as palavras por ordem alfabética
    // Cria um novo TreeMap a partir do HashMap e imprime as palavras e definições
    public void exibirPalavrasOrdenadas() {
        Map<String, String> dicionarioOrdenado = new TreeMap<>(dicionario);
        System.out.println(dicionarioOrdenado);
    }

    // Método para salvar o dicionário em um arquivo
    // Serializa o dicionário e salva em um arquivo binário
    public void salvarDicionario(String nomeArquivo) {
        try {
            // Obtém o diretório de trabalho atual
            String caminhoPastaApp = System.getProperty("user.dir");
            // Cria um objeto File com o caminho completo do arquivo
            File arquivoDicionario = new File(caminhoPastaApp, nomeArquivo);
            // Verifica se o diretório existe, se não, cria
            if (!arquivoDicionario.getParentFile().exists()) {
                arquivoDicionario.getParentFile().mkdirs();
            }
            // Cria o arquivo para escrita
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivoDicionario))) {
                outputStream.writeObject(dicionario);
                System.out.println("Dicionário salvo com sucesso em " + nomeArquivo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o dicionário: " + e.getMessage());
        }
    }

    // Método para carregar o dicionário de um arquivo
    // Deserializa o dicionário de um arquivo binário
    public void carregarDicionario(String nomeArquivo) {
        try {
            // Obtém o diretório de trabalho atual
            String caminhoPastaApp = System.getProperty("user.dir");
            // Cria um objeto File com o caminho completo do arquivo
            File arquivoDicionario = new File(caminhoPastaApp, nomeArquivo);
            // Verifica se o arquivo existe antes de tentar carregá-lo
            if (arquivoDicionario.exists()) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivoDicionario))) {
                    dicionario = (HashMap<String, String>) inputStream.readObject();
                    System.out.println("Dicionário carregado com sucesso de " + nomeArquivo);
                }
            } else {
                System.out.println("Arquivo '" + nomeArquivo + "' não encontrado.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o dicionário: " + e.getMessage());
        }
    }

    // Método para pesquisar por padrões (regex)
    // Busca por palavras que correspondam ao padrão fornecido
    public void pesquisarPorPadrao(String padrao) {
        Pattern pattern = Pattern.compile(padrao);
        for (Map.Entry<String, String> entry : dicionario.entrySet()) {
            Matcher matcher = pattern.matcher(entry.getKey());
            if (matcher.find()) {
                System.out.println("Palavra: " + entry.getKey() + ", Definição: " + entry.getValue());
            }
        }
    }

    // Método principal da classe
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Carregar dicionário de um arquivo (se existir)
        File arquivoDicionario = new File("dicionario.dat");
        if (arquivoDicionario.exists()) {
            dicionario.carregarDicionario("dicionario.dat");
        }

        // Adicionando palavras
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");
        dicionario.adicionarPalavra("python", "Linguagem de programação interpretada de alto nível.");

        // Exibindo todas as palavras
        dicionario.exibirPalavras();

        // Pesquisando palavras
        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        // Pesquisando por padrões (regex)
        System.out.println("Pesquisando por palavras que começam com 'p':");
        dicionario.pesquisarPorPadrao("^p");

        // Removendo uma palavra
        dicionario.removerPalavra("typescript");

        // Exibindo palavras ordenadas
        dicionario.exibirPalavrasOrdenadas();

        // Salvando o dicionário em um arquivo
        dicionario.salvarDicionario("dicionario.dat");
    }
}