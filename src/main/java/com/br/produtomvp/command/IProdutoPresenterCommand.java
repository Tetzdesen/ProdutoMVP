package com.br.produtomvp.command;

import com.br.produtomvp.presenter.ProdutoPresenter;

/**
 *
 * @author tetzner
 */
public interface IProdutoPresenterCommand {
    void executar(ProdutoPresenter presenter);
}
