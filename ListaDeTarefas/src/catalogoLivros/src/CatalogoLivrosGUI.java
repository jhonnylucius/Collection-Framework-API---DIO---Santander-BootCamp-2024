
package catalogoLivros.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoLivrosGUI {

    private CatalogoLivros catalogo;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField isbnField, tituloField, autorField;
    private JButton adicionarButton, removerButton, consultarButton, listarButton, sairButton;
    private JTextArea livrosArea;

    public CatalogoLivrosGUI() {
        catalogo = new CatalogoLivros();
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Catálogo de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de entrada de dados (Grid de 3 colunas)
        JPanel inputPanel = new JPanel(new GridLayout(3, 3, 10, 10)); 
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Livro"));

        // Primeira coluna (rótulos)
        JLabel isbnLabel = new JLabel("ISBN:");
        JLabel tituloLabel = new JLabel("Título:");
        JLabel autorLabel = new JLabel("Autor:");

        // Segunda e terceira colunas mescladas (campos de entrada e botão)
        isbnField = new JTextField();
        tituloField = new JTextField();
        autorField = new JTextField();
        adicionarButton = new JButton("Adicionar Livro");

        // Mescla as colunas 2 e 3 para os campos de entrada e o botão
        inputPanel.add(isbnLabel);
        inputPanel.add(isbnField);
        inputPanel.add(new JLabel()); // Adiciona um JLabel vazio para mesclar as colunas
        inputPanel.add(tituloLabel);
        inputPanel.add(tituloField);
        inputPanel.add(new JLabel()); // Adiciona um JLabel vazio para mesclar as colunas
        inputPanel.add(autorLabel);
        inputPanel.add(autorField);
        inputPanel.add(adicionarButton); // Botão na última linha

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        removerButton = new JButton("Remover Livro");
        consultarButton = new JButton("Consultar Livro");
        listarButton = new JButton("Listar Livros");
        sairButton = new JButton("Sair");

        buttonPanel.add(removerButton);
        buttonPanel.add(consultarButton);
        buttonPanel.add(listarButton);
        buttonPanel.add(sairButton);

        // Painel da área de texto
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Livros"));

        livrosArea = new JTextArea();
        livrosArea.setEditable(false);
        livrosArea.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane livrosScrollPane = new JScrollPane(livrosArea);
        outputPanel.add(livrosScrollPane, BorderLayout.CENTER);

        // Adiciona os painéis ao mainPanel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);

        // Adicionar Listener para o botão "Adicionar"
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });

        // Adicionar Listener para o botão "Remover"
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerLivro();
            }
        });

        // Adicionar Listener para o botão "Consultar"
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarLivro();
            }
        });

        // Adicionar Listener para o botão "Listar"
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLivros();
            }
        });

        // Adicionar Listener para o botão "Sair"
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void adicionarLivro() {
        String isbn = isbnField.getText();
        String titulo = tituloField.getText();
        String autor = autorField.getText();

        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        catalogo.adicionarLivros(new livros(isbn, titulo, autor));
        limparCamposDeEntrada();
        listarLivros(); // Atualiza a lista de livros após adicionar
    }

    private void removerLivro() {
        String isbn = JOptionPane.showInputDialog(frame, "Digite o ISBN do livro a ser removido:");
        if (isbn != null && !isbn.isEmpty()) {
            catalogo.removerLivos(isbn);
            listarLivros(); // Atualiza a lista de livros após remover
        }
    }

    private void consultarLivro() {
        String isbn = JOptionPane.showInputDialog(frame, "Digite o ISBN do livro a ser consultado:");
        if (isbn != null && !isbn.isEmpty()) {
            Livro livro = catalogo.consultarLivro(isbn);
            if (livro != null) {
                JOptionPane.showMessageDialog(frame, "Livro encontrado:\n" + livro.getTitulo() + " por " + livro.getAutor(), "Livro Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Livro não encontrado.", "Livro Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void listarLivros() {
        livrosArea.setText("");
        if (catalogo.getLivros().isEmpty()) {
            livrosArea.setText("O catálogo está vazio.");
        } else {
            for (Livros livros : catalogo.getLivros().values()) {
                livrosArea.append("ISBN: " + livros.getIsbn() + "\n");
                livrosArea.append("Título: " + livros.getTitulo() + "\n");
                livrosArea.append("Autor: " + livro.getAutor() + "\n\n");
            }
        }
    }

    private void limparCamposDeEntrada() {
        isbnField.setText("");
        tituloField.setText("");
        autorField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogoLivrosGUI();
            }
        });
    }
}