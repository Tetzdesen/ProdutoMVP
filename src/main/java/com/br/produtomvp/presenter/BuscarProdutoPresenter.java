package com.br.produtomvp.presenter;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.dao.GerenciadorProdutoService;
import com.br.produtomvp.model.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.br.produtomvp.observer.IProdutoObservador;
import com.br.produtomvp.view.BuscarProdutoView;

/**
 *
 * @author tetzner
 */
public final class BuscarProdutoPresenter implements IProdutoObservador {

    private final BuscarProdutoView viewBuscar;
    private final ProdutoCollection produtoCollection;
    private final GerenciadorProdutoService gerenciadorProduto;

    public BuscarProdutoPresenter(ProdutoCollection produtoCollection, GerenciadorProdutoService gerenciadorProduto) {
        if (produtoCollection == null) {
            throw new IllegalArgumentException("Produto Collection é nulo/invalido ");
        }
        this.viewBuscar = new BuscarProdutoView();
        this.produtoCollection = produtoCollection;
        this.gerenciadorProduto = gerenciadorProduto;
        configuraObserver();
        configuraView();

    }

    private void configuraObserver() {
        this.produtoCollection.adicionarObservador(this);
    }

    private void configuraView() {

        this.viewBuscar.setVisible(false);

        produtoCollection.adicionarObservador(this);

        this.viewBuscar.getBtnVisualizar().setEnabled(false);

        configuraListeners();

        viewBuscar.setLocationRelativeTo(null);

        atualizar(produtoCollection);

        this.viewBuscar.setVisible(true);

    }

    private void configuraListeners() {

        this.viewBuscar.getBtnNovo().addActionListener(e -> {
            criarProduto();
        });

        this.viewBuscar.getTblProdutos().getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int linhaSelecionada = this.viewBuscar.getTblProdutos().getSelectedRow();
                this.viewBuscar.getBtnVisualizar().setEnabled(linhaSelecionada != -1);
            }
        });

        this.viewBuscar.getBtnVisualizar().addActionListener(e -> {
            
            int linhaSelecionada = this.viewBuscar.getTblProdutos().getSelectedRow();

            if (linhaSelecionada != -1) {

                int confirmacao = JOptionPane.showConfirmDialog(
                        this.viewBuscar,
                        "Deseja visualizar o produto selecionado?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacao == JOptionPane.YES_OPTION) {
                    Produto produto = produtoCollection.getProdutos().get(linhaSelecionada);
                }
            }

        });

        // this.viewBuscar.getBtnLimparSelecao().addActionListener(event -> {
        //   this.viewListagem.getTblProdutos().clearSelection();
        //   });
        this.viewBuscar.getBtnFechar().addActionListener(e -> {
            fechar();
        });

    }

    private void listarProdutos() {
        List<Produto> produtosCadastrados = produtoCollection.getProdutos();

        String[] colunas = {"ID", "Nome", "Preço de Custo", "Percentual de Lucro", "Preço de Venda"};

        this.viewBuscar.getTblProdutos().setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        Object[][] dados = new Object[produtosCadastrados.size()][colunas.length];

        for (int i = 0; i < produtosCadastrados.size(); i++) {
            Produto produto = produtosCadastrados.get(i);
            dados[i][0] = i + 1;
            dados[i][1] = produto.getNome();
            dados[i][2] = String.format("%.2f", produto.getPrecoCusto());
            dados[i][3] = String.format("%.2f %%", produto.getPercentualLucro());
            dados[i][4] = String.format("%.2f", produto.getPrecoVenda());
        }

        DefaultTableModel tableModel = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        viewBuscar.getTblProdutos().setModel(tableModel);

        viewBuscar.getTblProdutos().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void criarProduto() {
        new ProdutoPresenter(produtoCollection, gerenciadorProduto);
    }

    private void fechar() {
        this.viewBuscar.dispose();
    }

    @Override
    public void atualizar(ProdutoCollection produtoCollection) {
        listarProdutos();
    }
}
