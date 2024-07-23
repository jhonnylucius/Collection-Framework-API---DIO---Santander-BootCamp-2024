package catalogoLivros.src;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CatalogoLivros {

    private List<Livros> livros;
    private List<String> livrosRemovidos;

    public CatalogoLivros() {
        livros = new ArrayList<>();
        livrosRemovidos = new ArrayList<>();
        carregarLivrosRemovidos();
    }

    public void adicionarLivros(Livros livro) {
        livros.add(livro);
    }

    public void removerLivros(String titulo) {
        livros.removeIf(l -> l.getTitulo().equals(titulo));
    }

    public Livros consultarLivro(String titulo) {
        for (Livros livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public List<String> getLivrosRemovidos() {
        return livrosRemovidos;
    }

    public void salvarLivroRemovido(String titulo, String dataHora) throws IOException {
        livrosRemovidos.add(titulo + " - Removido em: " + dataHora);
        File arquivo = new File("src/registros/" + titulo + ".txt");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        FileWriter writer = new FileWriter(arquivo);
        writer.write(titulo + "\n");
        writer.write("Data de Remoção: " + dataHora + "\n");
        writer.close();
    }

    public void salvarLivro(Livros livro) throws IOException {
        File arquivo = new File("src/registros/" + livro.getTitulo() + ".txt");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        FileWriter writer = new FileWriter(arquivo);
        writer.write(livro.getTitulo() + "\n");
        writer.write("Autor: " + livro.getAutor() + "\n");
        writer.write("Ano de Publicação: " + livro.getAnoPublicacao() + "\n");
        writer.write("Data de Inclusão: " + livro.getDataInclusao() + "\n");
        writer.close();
    }

    private void carregarLivrosRemovidos() {
        File diretorio = new File("src/registros");
        if (!diretorio.exists()) {
            diretorio.mkdir();
            return;
        }
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try (Scanner scanner = new Scanner(new FileReader(arquivo))) {
                    String titulo = scanner.nextLine();
                    String dataRemocao = scanner.nextLine().substring(16); // Remove "Data de Remoção: "
                    livrosRemovidos.add(titulo + " - Removido em: " + dataRemocao);
                } catch (IOException e) {
                    System.err.println("Erro ao carregar livro removido: " + e.getMessage());
                }
            }
        }
    }

    private void carregarLivros() {
        File diretorio = new File("src/registros");
        if (!diretorio.exists()) {
            diretorio.mkdir();
            return;
        }
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try (Scanner scanner = new Scanner(new FileReader(arquivo))) {
                    String titulo = scanner.nextLine();
                    String autor = scanner.nextLine().substring(6); // Remove "Autor: "
                    String anoPublicacao = scanner.nextLine().substring(18); // Remove "Ano de Publicação: "
                    String dataInclusao = scanner.nextLine().substring(17); // Remove "Data de Inclusão: "
                    Livros livro = new Livros(titulo, autor, Integer.parseInt(anoPublicacao));
                    livro.setDataRemocao(null); // Inicializa data de remoção como null
                    livros.add(livro);
                } catch (IOException e) {
                    System.err.println("Erro ao carregar livro: " + e.getMessage());
                }
            }
        }
    }

    // Método para filtrar livros com base nos filtros
    public List<Livros> filtrarLivros(List<String> filtros) {
        List<Livros> livrosEncontrados = new ArrayList<>();
        File diretorio = new File("src/registros");
        if (!diretorio.exists()) {
            diretorio.mkdir();
            return livrosEncontrados; // Retorna lista vazia se o diretório não existir
        }
        File[] arquivos = diretorio.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try (Scanner scanner = new Scanner(new FileReader(arquivo))) {
                    String titulo = scanner.nextLine();
                    String autor = scanner.nextLine().substring(6); // Remove "Autor: "
                    String anoPublicacao = scanner.nextLine().substring(18); // Remove "Ano de Publicação: "
                    String dataInclusao = scanner.nextLine().substring(17); // Remove "Data de Inclusão: "

                    Livros livro = new Livros(titulo, autor, Integer.parseInt(anoPublicacao));
                    livro.setDataRemocao(LocalDateTime.parse(dataInclusao, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))); // Define a data de remoção como data de inclusão

                    // Verifica se o livro atende aos filtros
                    boolean correspondeAtodosFiltros = true;
                    for (String filtro : filtros) {
                        switch (filtro) {
                            case "titulo":
                                if (!livro.getTitulo().toLowerCase().contains(filtro.toLowerCase())) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            case "autor":
                                if (!livro.getAutor().toLowerCase().contains(filtro.toLowerCase())) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            case "anoPublicacao":
                                if (Integer.parseInt(anoPublicacao) != livro.getAnoPublicacao()) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            case "diaEntrada":
                                LocalDate dataInclusaoLocalDate = LocalDate.parse(dataInclusao, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                                if (dataInclusaoLocalDate.getDayOfMonth() != LocalDate.now().getDayOfMonth()) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            case "periodoEntrada":
                                if (!livro.getDataInclusao().toString().contains(filtro.toLowerCase())) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            case "periodoRemocao":
                                if (livro.getDataRemocao() != null && !livro.getDataRemocao().toString().contains(filtro.toLowerCase())) {
                                    correspondeAtodosFiltros = false;
                                }
                                break;
                            default:
                                break;
                        }
                        if (!correspondeAtodosFiltros) {
                            break;
                        }
                    }

                    if (correspondeAtodosFiltros) {
                        livrosEncontrados.add(livro);
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao carregar livro: " + e.getMessage());
                }
            }
        }
        return livrosEncontrados;
    }
}