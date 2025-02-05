package com.br.produtomvp.presenter;

import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.state.InclusaoState;
import com.br.produtomvp.state.ProdutoPresenterState;
import com.br.produtomvp.state.VisualizacaoState;
import com.br.produtomvp.view.ProdutoView;

/**
 *
 * @author tetzner
 */
public final class ProdutoPresenter {

    private final ProdutoView view;
    private final GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService;
    private Produto produto;
    private ProdutoPresenterState estado;

    public ProdutoPresenter(Produto produto, GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService) {

        this.gerenciadorRepositoryProdutoService = gerenciadorRepositoryProdutoService;
        this.view = new ProdutoView();
        configuraView();

        if (produto == null) {
            this.estado = new InclusaoState(this);
        } else {
            this.produto = produto;
            preencherCampos();
            this.estado = new VisualizacaoState(this);
        }

    }

    private void configuraView() {
        this.view.setVisible(false);
        //  configurarListeners();
        view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public ProdutoView getView() {
        return view;
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

    public void salvar() {
        estado.salvar();
    }

    public void excluir() {
        estado.excluir();
    }

    public void editar() {
        estado.editar();
    }

    public void cancelar() {
        estado.cancelar();
    }

    private void preencherCampos() {
        view.getTxtNome().setText(produto.getNome());
        view.getTxtPrecoCusto().setText(String.valueOf(produto.getPrecoCusto()));
        view.getTxtPercentualLucro().setText(String.valueOf(produto.getPercentualLucro()));
        view.getTxtPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));
    }

}
