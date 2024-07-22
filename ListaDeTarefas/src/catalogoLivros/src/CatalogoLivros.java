package catalogoLivros.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoLivros<Livro> {

    private Map<String, Livro> livros;
    private List<Livro> livrosRemovidos;

    public CatalogoLivros() {
        livros = new HashMap<>();
        livrosRemovidos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.put(((Object) livro).getIsbn(), livro);
    }

    public void removerLivro(String isbn) {
        if (livros.containsKey(isbn)) {
            Livro livroRemovido = livros.remove(isbn);
            livrosRemovidos.add(livroRemovido);
        }
    }

    public Livro consultarLivro(String isbn) {
        return livros.get(isbn);
    }

 

    public List<Livro> getLivrosRemovidos() {
        return livrosRemovidos;
    }
}

    public Object getLivros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLivros'");
    }