
package carrinhoDeCompra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;

public class CarrinhoDeCompraGUI {

    private CarrinhoDeCompras carrinho;

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField descricaoField, quantidadeField, precoField;
    private JButton removerButton, listarButton, listarRemovidosButton, sairButton;
    private JTextArea itensArea, itensRemovidosArea;

    public CarrinhoDeCompraGUI() {
        carrinho = new CarrinhoDeCompras();
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Carrinho de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Item"));

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoField = new JTextField();
        JLabel quantidadeLabel = new JLabel("Quantidade:");
        quantidadeField = new JTextField();
        JLabel precoLabel = new JLabel("Preço Unitário:");
        precoField = new JTextField();

        inputPanel.add(descricaoLabel);
        inputPanel.add(descricaoField);
        inputPanel.add(quantidadeLabel);
        inputPanel.add(quantidadeField);
        inputPanel.add(precoLabel);
        inputPanel.add(precoField);

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
        JPanel outputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Lista de Itens"));

        itensArea = new JTextArea();
        itensArea.setEditable(false);
        itensArea.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane itensScrollPane = new JScrollPane(itensArea);

        itensRemovidosArea = new JTextArea();
        itensRemovidosArea.setEditable(false);
        itensRemovidosArea.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane itensRemovidosScrollPane = new JScrollPane(itensRemovidosArea);

        outputPanel.add(itensScrollPane);
        outputPanel.add(itensRemovidosScrollPane);

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
            preco = Double.parseDouble(precoField.getText());
            carrinho.adicionarItens(descricao, quantidade, preco);
            limparCamposDeEntrada(); 
            atualizarListas(); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarListas() {
        itensArea.setText("");
        itensRemovidosArea.setText("");

        if (carrinho.obterNumeroTotalItens() > 0) {
            carrinho.obterDescricoesItens(itensArea);
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