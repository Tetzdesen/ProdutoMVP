package com.br.produtomvp.state;

import com.br.produtomvp.command.CancelarCommand;
import com.br.produtomvp.command.EditarProdutoCommand;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.presenter.ProdutoPresenter;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public class EdicaoState extends ProdutoPresenterState {

    public EdicaoState(ProdutoPresenter presenter) {
        super(presenter);
        configurarView();
    }

    private void configurarView() {

        presenter.getView().getBtnSalvar().addActionListener((ActionEvent e) -> {
            try {
                presenter.salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage());
            }
        });

        presenter.getView().getBtnCancelar().addActionListener((ActionEvent e) -> {
            presenter.cancelar();
        });
        habilitarComponentes();

    }

    @Override
    public void salvar() {
        new EditarProdutoCommand().executar(presenter);
    }

    @Override
    public void cancelar() {
        new CancelarCommand().executar(presenter);
    }

    private void habilitarComponentes() {
        presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnCancelar().setEnabled(true);
        presenter.getView().getBtnEditar().setEnabled(false);
        presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getTxtNome().setEnabled(true);
        presenter.getView().getTxtPrecoCusto().setEnabled(true);
        presenter.getView().getTxtPercentualLucro().setEnabled(true);
        presenter.getView().getTxtPrecoVenda().setEnabled(true);
        presenter.getView().getTxtNome().setEditable(true);
        presenter.getView().getTxtPrecoCusto().setEditable(true);
        presenter.getView().getTxtPercentualLucro().setEditable(true);
        presenter.getView().getTxtPrecoVenda().setEditable(true);
    }

    @Override
    public String toString() {
        return "Edição";
    }
}
