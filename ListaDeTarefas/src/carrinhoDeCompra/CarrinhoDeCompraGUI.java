package carrinhoDeCompra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CarrinhoDeCompraGUI {

    private CarrinhoDeCompras carrinho;

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField descricaoField, quantidadeField, precoField;
    private JButton adicionarButton, removerButton, listarButton, listarRemovidosButton, sairButton;
    private JTextArea itensArea, itensRemovidosArea;
    private JLabel valorTotalLabel; // Label para exibir o valor total

    public CarrinhoDeCompraGUI() {
        carrinho = new CarrinhoDeCompras();
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Carrinho de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Define o tamanho inicial
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de entrada de dados (Grid de 3 colunas)
        JPanel inputPanel = new JPanel(new GridLayout(4, 3, 10, 10)); // Grid de 3 colunas
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Item"));

        // Primeira coluna (rótulos)
        JLabel descricaoLabel = new JLabel("Descrição:");
        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JLabel precoLabel = new JLabel("Preço Unitário:");

        // Segunda e terceira colunas mescladas (campos de entrada e botão)
        descricaoField = new JTextField();
        quantidadeField = new JTextField();
        precoField = new JTextField();
        adicionarButton = new JButton("Adicionar Item");

        // Mescla as colunas 2 e 3 para os campos de entrada e o botão
        inputPanel.add(descricaoLabel);
        inputPanel.add(descricaoField);
        inputPanel.add(new JLabel()); // Adiciona um JLabel vazio para mesclar as colunas
        inputPanel.add(quantidadeLabel);
        inputPanel.add(quantidadeField);
        inputPanel.add(new JLabel()); // Adiciona um JLabel vazio para mesclar as colunas
        inputPanel.add(precoLabel);
        inputPanel.add(precoField);
        inputPanel.add(adicionarButton); // Botão na última linha

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        removerButton = new JButton("Remover Item");
        listarButton = new JButton("Listar Itens");
        listarRemovidosButton = new JButton("Listar Itens Removidos");
        sairButton = new JButton("Sair");

        buttonPanel.add(removerButton);
        buttonPanel.add(listarButton);
        buttonPanel.add(listarRemovidosButton);
        buttonPanel.add(sairButton);

        // Painel de áreas de texto
        JPanel outputPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 2 colunas
        outputPanel.setBorder(BorderFactory.createTitledBorder("Lista de Itens"));

        // Painel da esquerda (itens)
        JPanel itensPanel = new JPanel(new BorderLayout());
        itensArea = new JTextArea();
        itensArea.setEditable(false);
        itensArea.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane itensScrollPane = new JScrollPane(itensArea);
        itensPanel.add(itensScrollPane, BorderLayout.CENTER); // Centraliza a área de texto

        // Label para o valor total
        valorTotalLabel = new JLabel("Valor Total: R$ 0,00"); // Inicializa com valor 0
        itensPanel.add(valorTotalLabel, BorderLayout.SOUTH); // Adiciona a label na parte inferior

        // Painel da direita (itens removidos)
        JPanel itensRemovidosPanel = new JPanel(new BorderLayout());
        itensRemovidosArea = new JTextArea();
        itensRemovidosArea.setEditable(false);
        itensRemovidosArea.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane itensRemovidosScrollPane = new JScrollPane(itensRemovidosArea);
        itensRemovidosPanel.add(itensRemovidosScrollPane, BorderLayout.CENTER);

        JLabel labelRemovidos = new JLabel("Itens Removidos"); // Label acima da lista de removidos
        itensRemovidosPanel.add(labelRemovidos, BorderLayout.NORTH); // Adiciona a label na parte superior

        outputPanel.add(itensPanel); // Adiciona o painel dos itens
        outputPanel.add(itensRemovidosPanel); // Adiciona o painel dos itens removidos

        // Adiciona os painéis ao mainPanel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);

        // Adicionar Listener para o campo "Preço" (para Enter e para ficar em branco)
        precoField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    adicionarItem();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (precoField.getText().isEmpty()) {
                    adicionarItem();
                }
            }
        });

        // Adicionar Listener para o botão "Adicionar"
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        // Adicionar Listener para o botão "Remover"
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = JOptionPane.showInputDialog(frame, "Digite a descrição do item a ser removido:");
                if (descricao != null && !descricao.isEmpty()) {
                    carrinho.removerItens(descricao);
                    atualizarListas();
                }
            }
        });

        // Adicionar Listener para o botão "Listar"
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListas();
            }
        });

        // Adicionar Listener para o botão "Listar Removidos"
        listarRemovidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListas();
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

    private void adicionarItem() {
        String descricao = descricaoField.getText();
        int quantidade;
        double preco;

        try {
            quantidade = Integer.parseInt(quantidadeField.getText());
            // Formata o preço para o padrão brasileiro (ex: 10,00)
            NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
            preco = format.parse(precoField.getText()).doubleValue(); // Parse do preço

            carrinho.adicionarItens(descricao, quantidade, preco);
            limparCamposDeEntrada();
            atualizarListas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Formato de preço inválido. Use o padrão brasileiro (ex: 10,00).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarListas() {
        itensArea.setText("");
        itensRemovidosArea.setText("");
        valorTotalLabel.setText("Valor Total: R$ 0,00"); // Zera o valor total

        if (carrinho.obterNumeroTotalItens() > 0) {
            carrinho.obterDescricoesItens(itensArea, valorTotalLabel); // Passa a label para o método
        } else {
            itensArea.setText("A lista de itens está vazia.");
        }

        if (!carrinho.getItensRemovidos().isEmpty()) {
            carrinho.obterDescricoesItensRemovidos(itensRemovidosArea);
        } else {
            itensRemovidosArea.setText("A lista de itens removidos está vazia.");
        }
    }

    private void limparCamposDeEntrada() {
        descricaoField.setText("");
        quantidadeField.setText("");
        precoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarrinhoDeCompraGUI();
            }
        });
    }
}