package com.br.produtomvp.command;

import com.br.produtomvp.presenter.ProdutoPresenter;

/**
 *
 * @author tetzner
 */
public class CancelarCommand implements IProdutoPresenterCommand {

    @Override
    public void executar(ProdutoPresenter presenter) {
        presenter.getView().dispose();
    }

}
