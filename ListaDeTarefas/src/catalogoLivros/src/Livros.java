package catalogoLivros.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Livros {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataRemocao;

    public Livros(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.dataInclusao = LocalDateTime.now();
        this.dataRemocao = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getDataInclusao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataInclusao.format(formatter);
    }

    public String getDataRemocao() {
        if (dataRemocao != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return dataRemocao.format(formatter);
        }
        return null;
    }

    public void setDataRemocao(LocalDateTime dataRemocao) {
        this.dataRemocao = dataRemocao;
    }
}