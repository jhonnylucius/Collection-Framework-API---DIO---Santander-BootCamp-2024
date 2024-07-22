package catalogoLivros.src;

public class Livros {
    private String isbn;
    private String titulo;
    private String autor;

    public void Livro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return titulo;
    }
}
