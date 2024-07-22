package catalogoLivros.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CatalogoLivrosGUI {

    private CatalogoLivros catalogo;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField anoPublicacaoJField, tituloField, autorField, pesquisaField;
    private JButton adicionarButton, removerButton, consultarButton, listarButton, sairButton, listarRemovidosButton, pesquisarButton;
    private JTextArea livrosArea;
    private JList<String> livrosList; // Lista para exibir os livros
    private DefaultListModel<String> livrosListModel; // Modelo para a lista
    private JList<String> livrosRemovidosList; // Lista para exibir os livros removidos
    private DefaultListModel<String> livrosRemovidosListModel; // Modelo para a lista de livros removidos

    public CatalogoLivrosGUI() {
        catalogo = new CatalogoLivros();
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Catálogo de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre a tela maximizada

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de entrada de dados (Grid de 3 colunas)
        JPanel inputPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Livro"));

        // Primeira coluna (rótulos)
        JLabel anoPublicacaoLabel = new JLabel("Ano de Publicação:");
        JLabel tituloLabel = new JLabel("Título:");
        JLabel autorLabel = new JLabel("Autor:");

        // Segunda e terceira colunas mescladas (campos de entrada e botão)
        anoPublicacaoJField = new JTextField();
        tituloField = new JTextField();
        autorField = new JTextField();
        adicionarButton = new JButton("Adicionar Livro");

        // Mescla as colunas 2 e 3 para os campos de entrada e o botão
        inputPanel.add(anoPublicacaoLabel);
        inputPanel.add(anoPublicacaoJField);
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
        listarRemovidosButton = new JButton("Listar Livros Removidos");

        buttonPanel.add(removerButton);
        buttonPanel.add(consultarButton);
        buttonPanel.add(listarButton);
        buttonPanel.add(listarRemovidosButton);
        buttonPanel.add(sairButton);

        // Painel da lista de livros
        JPanel livrosPanel = new JPanel(new BorderLayout());
        livrosPanel.setBorder(BorderFactory.createTitledBorder("Livros"));

        livrosListModel = new DefaultListModel<>();
        livrosList = new JList<>(livrosListModel);
        JScrollPane livrosScrollPane = new JScrollPane(livrosList);
        livrosPanel.add(livrosScrollPane, BorderLayout.CENTER);

        // Painel da lista de livros removidos
        JPanel livrosRemovidosPanel = new JPanel(new BorderLayout());
        livrosRemovidosPanel.setBorder(BorderFactory.createTitledBorder("Livros Removidos"));

        livrosRemovidosListModel = new DefaultListModel<>();
        livrosRemovidosList = new JList<>(livrosRemovidosListModel);
        JScrollPane livrosRemovidosScrollPane = new JScrollPane(livrosRemovidosList);
        livrosRemovidosPanel.add(livrosRemovidosScrollPane, BorderLayout.CENTER);

        // Adiciona os painéis ao mainPanel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(livrosPanel, BorderLayout.WEST);
        mainPanel.add(livrosRemovidosPanel, BorderLayout.EAST);

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

        // Adicionar Listener para o botão "Listar Removidos"
        listarRemovidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLivrosRemovidos();
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
        String anoPublicacao = anoPublicacaoJField.getText();
        String titulo = tituloField.getText();
        String autor = autorField.getText();

        if (anoPublicacao.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int ano = Integer.parseInt(anoPublicacao);
            catalogo.adicionarLivros(new Livros(titulo, autor, ano));
            limparCamposDeEntrada();
            listarLivros(); // Atualiza a lista de livros após adicionar
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ano de publicação inválido. Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerLivro() {
        int selectedIndex = livrosList.getSelectedIndex();
        if (selectedIndex != -1) {
            String titulo = livrosListModel.getElementAt(selectedIndex);
            catalogo.removerLivros(titulo);
            livrosListModel.remove(selectedIndex);
            // Adiciona o livro removido à lista de removidos com data e hora
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = now.format(formatter);
            livrosRemovidosListModel.addElement(titulo + " - Removido em: " + dataHora);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um livro para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarLivro() {
        int selectedIndex = livrosList.getSelectedIndex();
        if (selectedIndex != -1) {
            String titulo = livrosListModel.getElementAt(selectedIndex);
            Livros livro = catalogo.consultarLivro(titulo);
            if (livro != null) {
                JOptionPane.showMessageDialog(frame, "Livro encontrado:\n" + livro.getTitulo() + " por " + livro.getAutor() + " (Ano: " + livro.getAnoPublicacao() + ")", "Livro Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Livro não encontrado.", "Livro Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um livro para consultar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarLivros() {
        livrosListModel.clear();
        for (Livros livro : catalogo.getLivros()) {
            livrosListModel.addElement(livro.getTitulo());
        }
    }

    private void listarLivrosRemovidos() {
        livrosRemovidosListModel.clear();
        for (String livroRemovido : catalogo.getLivrosRemovidos()) {
            livrosRemovidosListModel.addElement(livroRemovido);
        }
    }

    private void limparCamposDeEntrada() {
        anoPublicacaoJField.setText("");
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