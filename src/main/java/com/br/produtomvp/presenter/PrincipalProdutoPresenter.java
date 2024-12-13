package com.br.produtomvp.presenter;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.view.PrincipalProdutoView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.br.produtomvp.observer.IProdutoObservador;

/**
 *
 * @author tetzner
 */
public final class PrincipalProdutoPresenter implements IProdutoObservador {

    private final PrincipalProdutoView viewPrincipal;
    private final ProdutoCollection produtoCollection;

    public PrincipalProdutoPresenter(ProdutoCollection produtoCollection) {
        if(produtoCollection == null){
            throw new IllegalArgumentException("Produto Collection nulo/invalido");
        }
        this.viewPrincipal = new PrincipalProdutoView();
        this.produtoCollection = produtoCollection;
        configuraObserver();
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
                new InclusaoProdutoPresenter(produtoCollection);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        this.viewPrincipal.getMnuItemListarProdutos().addActionListener((ActionEvent e) -> {
            try {
                new ListagemProdutoPresenter(produtoCollection);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }

    @Override
    public void atualizar(ProdutoCollection produtoCollection) {
        this.viewPrincipal.getLblQuantidadeProdutos().setText(String.valueOf(produtoCollection.obterQuantidadeDeProdutos()));
    }

}
