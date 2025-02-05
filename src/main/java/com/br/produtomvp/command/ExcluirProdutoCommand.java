package com.br.produtomvp.command;

import com.br.produtomvp.presenter.ProdutoPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public class ExcluirProdutoCommand implements IProdutoPresenterCommand{

    @Override
    public void executar(ProdutoPresenter presenter) {
        presenter.getGerenciadorRepositoryProdutoService().deletarProdutoPorID(presenter.getProduto().getIdProduto());
        JOptionPane.showMessageDialog(presenter.getView(), "Produto excluido com sucesso");
    }
    
}
