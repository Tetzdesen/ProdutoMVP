package com.br.produtomvp.presenter;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.dao.GerenciadorProdutoService;
import com.br.produtomvp.dao.ProdutoDAO;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.view.PrincipalProdutoView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.br.produtomvp.observer.IProdutoObservador;
import java.util.List;

/**
 *
 * @author tetzner
 */
public final class PrincipalProdutoPresenter implements IProdutoObservador {

    private final PrincipalProdutoView viewPrincipal;
    private final ProdutoCollection produtoCollection;
    private final GerenciadorProdutoService gerenciadorProduto;
    
    public PrincipalProdutoPresenter(ProdutoDAO produtoDAO) {
        this.viewPrincipal = new PrincipalProdutoView();
        this.produtoCollection = new ProdutoCollection();
        this.gerenciadorProduto = new GerenciadorProdutoService(produtoDAO);        
        configuraObserver();
        copiarDadosProdutosParaCollection();
        configuraView();
    }

    private void configuraObserver() {
        this.produtoCollection.adicionarObservador(this);
    }

    private void configuraView() {
        this.viewPrincipal.setVisible(false);
        configuraListeners();
        this.viewPrincipal.setLocationRelativeTo(null);
        this.viewPrincipal.setVisible(true);
    }

    private void configuraListeners() {
        this.viewPrincipal.getMnuItemIncluir().addActionListener((ActionEvent e) -> {
            try {
                new ProdutoPresenter(produtoCollection, gerenciadorProduto);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        this.viewPrincipal.getMnuItemBuscarProdutos().addActionListener((ActionEvent e) -> {
            try {
                new BuscarProdutoPresenter(produtoCollection, gerenciadorProduto);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }
    
    private void copiarDadosProdutosParaCollection(){
        List<Produto> produtos = gerenciadorProduto.buscarProdutos();
        
        for(int i = 0; i < produtos.size(); i++) produtoCollection.adicionarProduto(produtos.get(i));
    }

    @Override
    public void atualizar(ProdutoCollection produtoCollection) {
        this.viewPrincipal.getLblQuantidadeProdutos().setText(String.valueOf(produtoCollection.obterQuantidadeDeProdutos()));
    }

}
