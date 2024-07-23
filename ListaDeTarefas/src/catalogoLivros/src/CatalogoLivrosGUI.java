package catalogoLivros.src;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CatalogoLivrosGUI {

    private CatalogoLivros catalogo;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField anoPublicacaoJField, tituloField, autorField;
    private JButton adicionarButton, removerButton, consultarButton, sairButton, gerarRelatorioButton;
    private JList<String> livrosList; // Lista para exibir os livros
    private DefaultListModel<String> livrosListModel; // Modelo para a lista
    private JList<String> livrosRemovidosList; // Lista para exibir os livros removidos
    private DefaultListModel<String> livrosRemovidosListModel; // Modelo para a lista de livros removidos

    private static final String LIVROS_FILE_PATH = "src/registros/livros.txt";
    private static final String LIVROS_REMOVIDOS_FILE_PATH = "src/registros/livros_removidos.txt";

    public CatalogoLivrosGUI() {
        catalogo = new CatalogoLivros();
        criarGUI();
        carregarLivros();
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
        sairButton = new JButton("Sair");
        gerarRelatorioButton = new JButton("Gerar Relatórios");

        buttonPanel.add(removerButton);
        buttonPanel.add(consultarButton);
        buttonPanel.add(gerarRelatorioButton);
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

        // Adicionar Listener para o botão "Gerar Relatórios"
        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaRelatorios();
            }
        });

        // Adicionar Listener para o botão "Sair"
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarLivros();
                System.exit(0);
            }
        });

        // Atualiza a lista de livros inicialmente
        atualizarListaLivros();
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
            Livros livro = new Livros(titulo, autor, ano);
            catalogo.adicionarLivros(livro);
            limparCamposDeEntrada();
            atualizarListaLivros();
            salvarLivros();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ano de publicação inválido. Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerLivro() {
        int selectedIndex = livrosList.getSelectedIndex();
        if (selectedIndex != -1) { // Verifica se um livro está selecionado
            String titulo = livrosListModel.getElementAt(selectedIndex);
            catalogo.removerLivros(titulo);
            livrosListModel.remove(selectedIndex);
            // Adiciona o livro removido à lista de removidos com data e hora
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = now.format(formatter);
            livrosRemovidosListModel.addElement(titulo + " - Removido em: " + dataHora);
            salvarLivrosRemovidos(titulo, dataHora);
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
                JOptionPane.showMessageDialog(frame, "Livro encontrado:\n" + livro.getTitulo() + " por " + livro.getAutor() + " (Publicado em " + livro.getAnoPublicacao() + ")");
            } else {
                JOptionPane.showMessageDialog(frame, "Livro não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um livro para consultar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirTelaRelatorios() {
        // Cria um novo JFrame para os relatórios
        JFrame relatorioFrame = new JFrame("Gerar Relatórios");
        relatorioFrame.setSize(600, 400);
        relatorioFrame.setLocationRelativeTo(frame);

        JPanel relatorioPanel = new JPanel(new BorderLayout());
        relatorioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de filtros
        JPanel filtrosPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        filtrosPanel.setBorder(BorderFactory.createTitledBorder("Filtros"));

        JCheckBox tituloCheckBox = new JCheckBox("Título:");
        JCheckBox autorCheckBox = new JCheckBox("Autor:");
        JCheckBox anoCheckBox = new JCheckBox("Ano de Publicação:");

        JTextField tituloFiltroField = new JTextField();
        JTextField autorFiltroField = new JTextField();
        JTextField anoFiltroField = new JTextField();

        filtrosPanel.add(tituloCheckBox);
        filtrosPanel.add(tituloFiltroField);
        filtrosPanel.add(autorCheckBox);
        filtrosPanel.add(autorFiltroField);
        filtrosPanel.add(anoCheckBox);
        filtrosPanel.add(anoFiltroField);

        // Botão para gerar relatório
        JButton gerarButton = new JButton("Gerar Relatório");

        // Adiciona os filtros e o botão ao painel de relatórios
        relatorioPanel.add(filtrosPanel, BorderLayout.CENTER);
        relatorioPanel.add(gerarButton, BorderLayout.SOUTH);

        relatorioFrame.setContentPane(relatorioPanel);
        relatorioFrame.setVisible(true);

        // Adiciona o listener para o botão "Gerar Relatório"
        gerarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean filtrarPorTitulo = tituloCheckBox.isSelected();
                boolean filtrarPorAutor = autorCheckBox.isSelected();
                boolean filtrarPorAno = anoCheckBox.isSelected();

                String tituloFiltro = tituloFiltroField.getText();
                String autorFiltro = autorFiltroField.getText();
                String anoFiltro = anoFiltroField.getText();

                List<Livros> livrosFiltrados = new ArrayList<>(catalogo.getLivros());

                if (filtrarPorTitulo) {
                    livrosFiltrados.removeIf(livro -> !livro.getTitulo().toLowerCase().contains(tituloFiltro.toLowerCase()));
                }

                if (filtrarPorAutor) {
                    livrosFiltrados.removeIf(livro -> !livro.getAutor().toLowerCase().contains(autorFiltro.toLowerCase()));
                }

                if (filtrarPorAno) {
                    try {
                        int ano = Integer.parseInt(anoFiltro);
                        livrosFiltrados.removeIf(livro -> livro.getAnoPublicacao() != ano);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(relatorioFrame, "Ano de publicação inválido. Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (livrosFiltrados.isEmpty()) {
                    JOptionPane.showMessageDialog(relatorioFrame, "Nenhum livro encontrado com os filtros selecionados.", "Relatório", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    gerarRelatorio(livrosFiltrados);
                }
            }
        });
    }

    private void gerarRelatorio(List<Livros> livrosFiltrados) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Livros:\n\n");

        for (Livros livro : livrosFiltrados) {
            relatorio.append("Título: ").append(livro.getTitulo()).append("\n");
            relatorio.append("Autor: ").append(livro.getAutor()).append("\n");
            relatorio.append("Ano de Publicação: ").append(livro.getAnoPublicacao()).append("\n\n");
        }

        JOptionPane.showMessageDialog(frame, relatorio.toString(), "Relatório", JOptionPane.INFORMATION_MESSAGE);

        // Salva o relatório em um arquivo .txt
        try (FileWriter writer = new FileWriter("src/relatorios/relatorio_livros.txt")) {
            writer.write(relatorio.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao salvar relatório.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCamposDeEntrada() {
        anoPublicacaoJField.setText("");
        tituloField.setText("");
        autorField.setText("");
    }

    private void atualizarListaLivros() {
        livrosListModel.clear();
        for (Livros livro : catalogo.getLivros()) {
            livrosListModel.addElement(livro.getTitulo());
        }
    }

    private void salvarLivros() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LIVROS_FILE_PATH))) {
            for (Livros livro : catalogo.getLivros()) {
                writer.println(livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getAnoPublicacao());
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao salvar livros.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarLivros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LIVROS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String titulo = parts[0];
                    String autor = parts[1];
                    int ano = Integer.parseInt(parts[2]);
                    Livros livro = new Livros(titulo, autor, ano);
                    catalogo.adicionarLivros(livro);
                }
            }
            atualizarListaLivros();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao carregar livros.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarLivrosRemovidos(String titulo, String dataHora) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LIVROS_REMOVIDOS_FILE_PATH, true))) {
            writer.println(titulo + ";" + dataHora);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao salvar livros removidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarLivrosRemovidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LIVROS_REMOVIDOS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String titulo = parts[0];
                    String dataHora = parts[1];
                    livrosRemovidosListModel.addElement(titulo + " - Removido em: " + dataHora);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao carregar livros removidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
