package com.br.produtomvp.presenter;

import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.state.InclusaoState;
import com.br.produtomvp.state.ProdutoPresenterState;
import com.br.produtomvp.state.VisualizacaoState;
import com.br.produtomvp.view.ProdutoView;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public final class ProdutoPresenter {

    private final ProdutoView viewInclusao;
    private final GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService;
    private Produto produto;
    private ProdutoPresenterState estado;

    public ProdutoPresenter(Produto produto, GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService) {
        this.gerenciadorRepositoryProdutoService = gerenciadorRepositoryProdutoService;
        this.viewInclusao = new ProdutoView();
        if (produto == null) {
            this.estado = new InclusaoState(this);
        } else {
            this.produto = produto;
            preencherCampos();
            this.estado = new VisualizacaoState(this);
        }
        //   this.produto = produto;

        configuraView();

    }

    private void configuraView() {
        this.viewInclusao.setVisible(false);
        // configurarListeners();
        viewInclusao.setLocationRelativeTo(null);
        this.viewInclusao.setVisible(true);
    }

    public ProdutoView getViewInclusao() {
        return viewInclusao;
    }

    public GerenciadorRepositoryProdutoService getGerenciadorRepositoryProdutoService() {
        return gerenciadorRepositoryProdutoService;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setState(ProdutoPresenterState estado) {
        this.estado = estado;
    }

   /* public void configurarListeners() {
        viewInclusao.getBtnSalvar().addActionListener((ActionEvent e) -> {
            try {
                salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewInclusao, ex.getMessage());
            }
        });

        viewInclusao.getBtnExcluir().addActionListener((ActionEvent e) -> {
            try {
                excluir();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewInclusao, ex.getMessage());
            }
        });

        viewInclusao.getBtnEditar().addActionListener((ActionEvent e) -> {
            try {
                editar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewInclusao, ex.getMessage());
            }
        });

        viewInclusao.getBtnCancelar().addActionListener((ActionEvent e) -> {
            cancelar();
        });
    }*/

    private void preencherCampos() {
        viewInclusao.getTxtNome().setText(produto.getNome());
        viewInclusao.getTxtPrecoCusto().setText(String.valueOf(produto.getPrecoCusto()));
        viewInclusao.getTxtPercentualLucro().setText(String.valueOf(produto.getPercentualLucro()));
        viewInclusao.getTxtPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));
    }

}
