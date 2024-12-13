package com.br.produtomvp.presenter;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.view.ListagemProdutoView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.br.produtomvp.observer.IProdutoObservador;

/**
 *
 * @author tetzner
 */
public final class ListagemProdutoPresenter implements IProdutoObservador {

    private final ListagemProdutoView viewListagem;
    private final ProdutoCollection produtoCollection;

    public ListagemProdutoPresenter(ProdutoCollection produtoCollection) {

        this.viewListagem = new ListagemProdutoView();
        this.produtoCollection = produtoCollection;
        configuraObserver();
        configuraView();

    }
    
    private void configuraObserver() {
        this.produtoCollection.adicionarObservador(this);
    }

    private void configuraView() {

        this.viewListagem.setVisible(false);

        produtoCollection.adicionarObservador(this);

        this.viewListagem.getBtnRemover().setEnabled(false);

        configuraListeners();

        viewListagem.setLocationRelativeTo(null);

        this.viewListagem.setVisible(true);

    }

    private void configuraListeners() {
        this.viewListagem.getBtnRemover().addActionListener(e -> {
            excluirProduto();
        });

        this.viewListagem.getTblProdutos().getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int linhaSelecionada = this.viewListagem.getTblProdutos().getSelectedRow();
                this.viewListagem.getBtnRemover().setEnabled(linhaSelecionada != -1);
            }
        });

        this.viewListagem.getBtnLimparSelecao().addActionListener(event -> {
            this.viewListagem.getTblProdutos().clearSelection();
        });

    }

    private void excluirProduto() {

        int linhaSelecionada = this.viewListagem.getTblProdutos().getSelectedRow();

        if (linhaSelecionada != -1) {

            int confirmacao = JOptionPane.showConfirmDialog(
                    this.viewListagem,
                    "Deseja remover o produto selecionado?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {

                System.out.println(linhaSelecionada);
                Produto produto = produtoCollection.getProdutos().get(linhaSelecionada);
                produtoCollection.removerProduto(produto);
                JOptionPane.showMessageDialog(viewListagem, "Produto excluido com sucesso");
                System.out.println(produtoCollection.getProdutos());
            }
        }

    }

    @Override
    public void atualizar(ProdutoCollection produtoCollection) {
        List<Produto> produtosCadastrados = produtoCollection.getProdutos();

        String[] colunas = {"ID", "Nome", "Preço de Custo", "Percentual de Lucro", "Preço de Venda"};

        this.viewListagem.getTblProdutos().setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        Object[][] dados = new Object[produtosCadastrados.size()][colunas.length];

        for (int i = 0; i < produtosCadastrados.size(); i++) {
            Produto produto = produtosCadastrados.get(i);
            dados[i][0] = i + 1;
            dados[i][1] = produto.getNome();
            dados[i][2] = produto.getPrecoCusto();
            dados[i][3] = String.format("%.2f %%", produto.getPercentualLucro());
            dados[i][4] = produto.getPrecoVenda();
        }

        DefaultTableModel tableModel = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        viewListagem.getTblProdutos().setModel(tableModel);

        viewListagem.getTblProdutos().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}