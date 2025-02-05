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
      //  removeListeners();
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

        ActionListener listenersBtnSalvar[] = presenter.getView().getBtnSalvar().getActionListeners();
        ActionListener listenersBtnExcluir[] = presenter.getView().getBtnExcluir().getActionListeners();
        ActionListener listenersBtnEditar[] = presenter.getView().getBtnEditar().getActionListeners();
        ActionListener listenersBtnCancelar[] = presenter.getView().getBtnCancelar().getActionListeners();
        
        for (ActionListener listener : listenersBtnSalvar) {
            presenter.getView().getBtnSalvar().removeActionListener(listener);
        }
        
        for (ActionListener listener : listenersBtnExcluir) {
            presenter.getView().getBtnExcluir().removeActionListener(listener);
        }
         
        for (ActionListener listener : listenersBtnEditar) {
            presenter.getView().getBtnEditar().removeActionListener(listener);
        }
        
        for (ActionListener listener : listenersBtnCancelar) {
            presenter.getView().getBtnCancelar().removeActionListener(listener);
        }
    }
}
