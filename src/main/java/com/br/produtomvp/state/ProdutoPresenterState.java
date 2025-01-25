/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.produtomvp.state;

import com.br.produtomvp.presenter.ProdutoPresenter;
import java.awt.event.ActionListener;

/**
 *
 * @author tetzner
 */
public abstract class ProdutoPresenterState {

    protected ProdutoPresenter presenter;

    public ProdutoPresenterState(ProdutoPresenter presenter) {
        this.presenter = presenter;
       // removeListeners();
    }

    public void salvar() {
        throw new RuntimeException("Não é possível salvar a partir do estado " + toString());
    }

    public void excluir() {
        throw new RuntimeException("Não é possível excluir a partir do estado " + toString());
    }

    public void editar() {
        throw new RuntimeException("Não é possível editar a partir do estado " + toString());
    }

    public void cancelar() {
        throw new RuntimeException("Não é possível cancelar a partir do estado " + toString());
    }

    private void removeListeners() {

        ActionListener listeners[] = presenter.getViewInclusao().getBtnSalvar().getActionListeners();
        for (ActionListener listener : listeners) {
            presenter.getViewInclusao().getBtnSalvar().removeActionListener(listener);
        }
    }
}
