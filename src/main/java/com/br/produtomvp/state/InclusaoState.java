package com.br.produtomvp.state;

import com.br.produtomvp.command.CancelarCommand;
import com.br.produtomvp.command.SalvarProdutoCommand;
import com.br.produtomvp.presenter.ProdutoPresenter;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public class InclusaoState extends ProdutoPresenterState {

    public InclusaoState(ProdutoPresenter presenter) {
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
       // limparCampos();
        
    }
    
    @Override
    public void salvar() {
        new SalvarProdutoCommand().executar(presenter);
    } 
    
    @Override
    public void cancelar() {
       new CancelarCommand().executar(presenter);
    }

    private void habilitarComponentes(){
       // presenter.getView().getBtnSalvar().setEnabled(true);
       // presenter.getView().getBtnEditar().setEnabled(false);
      //  presenter.getView().getBtnExcluir().setEnabled(false);
      //  presenter.getView().getBtnCancelar().setEnabled(true);
        presenter.getView().getTxtNome().setEnabled(true);
        presenter.getView().getTxtPrecoCusto().setEnabled(true);
        presenter.getView().getTxtPercentualLucro().setEnabled(true);
        presenter.getView().getTxtPrecoVenda().setEnabled(true);
    }
    
    @Override
    public String toString() {
        return "Inclusão";
    }

}
