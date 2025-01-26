package com.br.produtomvp.presenter;

import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;
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
    private final GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService;
    
    public PrincipalProdutoPresenter(GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService) {
        this.viewPrincipal = new PrincipalProdutoView();
        this.gerenciadorRepositoryProdutoService = gerenciadorRepositoryProdutoService;
        configuraObserver();
        configuraView();
    }

    private void configuraObserver() {
        this.gerenciadorRepositoryProdutoService.adicionarObservador(this);
    }

    private void configuraView() {
        this.viewPrincipal.setVisible(false);
        configuraListeners();
        atualizar(gerenciadorRepositoryProdutoService);
        this.viewPrincipal.setLocationRelativeTo(null);
        this.viewPrincipal.setVisible(true);
    }

    private void configuraListeners() {
        this.viewPrincipal.getMnuItemIncluir().addActionListener((ActionEvent e) -> {
            try {
                new ProdutoPresenter(null, gerenciadorRepositoryProdutoService);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        this.viewPrincipal.getMnuItemBuscarProdutos().addActionListener((ActionEvent e) -> {
            try {
                new BuscarProdutoPresenter(gerenciadorRepositoryProdutoService);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }
   
    @Override
    public void atualizar(GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService) {
        this.viewPrincipal.getLblQuantidadeProdutos().setText(String.valueOf(gerenciadorRepositoryProdutoService.obterQuantidadeTotalDeProdutos()));
    }

}
