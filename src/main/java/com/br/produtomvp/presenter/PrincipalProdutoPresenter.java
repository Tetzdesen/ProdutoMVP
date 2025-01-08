package com.br.produtomvp.presenter;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.dao.GerenciadorProdutoService;
import com.br.produtomvp.dao.ProdutoDAOSQLite;
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
    
    public PrincipalProdutoPresenter(ProdutoCollection produtoCollection) {
        if(produtoCollection == null){
            throw new IllegalArgumentException("Produto Collection nulo/invalido");
        }
        this.viewPrincipal = new PrincipalProdutoView();
        this.produtoCollection = produtoCollection;
        this.gerenciadorProduto = new GerenciadorProdutoService(new ProdutoDAOSQLite());        
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
                new InclusaoProdutoPresenter(produtoCollection, gerenciadorProduto);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        this.viewPrincipal.getMnuItemListarProdutos().addActionListener((ActionEvent e) -> {
            try {
                new ListagemProdutoPresenter(produtoCollection, gerenciadorProduto);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        
        this.viewPrincipal.getMnuRadioJSON().addActionListener((ActionEvent e) -> {
            try {
                  this.viewPrincipal.getMnuRadioXML().setSelected(false);
                  this.viewPrincipal.getMnuRadioSQLite().setSelected(false);
                  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        
        this.viewPrincipal.getMnuRadioXML().addActionListener((ActionEvent e) -> {
            try {
                  this.viewPrincipal.getMnuRadioJSON().setSelected(false);
                  this.viewPrincipal.getMnuRadioSQLite().setSelected(false);
                  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        
          this.viewPrincipal.getMnuRadioSQLite().addActionListener((ActionEvent e) -> {
            try {
                  this.viewPrincipal.getMnuRadioJSON().setSelected(false);
                  this.viewPrincipal.getMnuRadioXML().setSelected(false);
                  
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
