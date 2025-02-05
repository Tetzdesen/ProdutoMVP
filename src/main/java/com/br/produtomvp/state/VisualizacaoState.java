package com.br.produtomvp.state;

import com.br.produtomvp.command.CancelarCommand;
import com.br.produtomvp.command.ExcluirProdutoCommand;
import com.br.produtomvp.presenter.ProdutoPresenter;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public class VisualizacaoState extends ProdutoPresenterState {

    public VisualizacaoState(ProdutoPresenter presenter) {
        super(presenter);
        configurarView();
        
    }

    private void configurarView() {
        presenter.getView().getBtnExcluir().addActionListener((ActionEvent e) -> {
            try {
                presenter.excluir();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage());
            }
        });

        presenter.getView().getBtnEditar().addActionListener((ActionEvent e) -> {
            presenter.editar();
        });
        
         presenter.getView().getBtnCancelar().addActionListener((ActionEvent e) -> {
            fechar();
        });
        preencherCampos();
        habilitarComponentes();
    }

    private void habilitarComponentes() {
        presenter.getView().getBtnEditar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(true);
        presenter.getView().getBtnSalvar().setEnabled(false);
        presenter.getView().getBtnCancelar().setEnabled(true);
        presenter.getView().getTxtNome().setEnabled(true);
        presenter.getView().getTxtPrecoCusto().setEnabled(true);
        presenter.getView().getTxtPercentualLucro().setEnabled(true);
        presenter.getView().getTxtPrecoVenda().setEnabled(true);
        presenter.getView().getTxtNome().setEditable(false);
        presenter.getView().getTxtPrecoCusto().setEditable(false);
        presenter.getView().getTxtPercentualLucro().setEditable(false);
        presenter.getView().getTxtPrecoVenda().setEditable(false);
    }

    @Override
    public void excluir() {
        int confirmacao = JOptionPane.showConfirmDialog(
                this.presenter.getView(),
                "Deseja remover o produto selecionado?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
           new ExcluirProdutoCommand().executar(presenter);
           fechar();
        } else {
            presenter.setState(new VisualizacaoState(presenter));
        }
    }

    @Override
    public void editar() {
        presenter.setState(new EdicaoState(presenter));
    }

    public void fechar() {
        new CancelarCommand().executar(presenter);
    }
    
    private void preencherCampos() {
        presenter.getView().getTxtNome().setText(presenter.getProduto().getNome());
        presenter.getView().getTxtPrecoCusto().setText(String.valueOf(presenter.getProduto().getPrecoCusto()));
        presenter.getView().getTxtPercentualLucro().setText(String.valueOf(presenter.getProduto().getPercentualLucro()));
        presenter.getView().getTxtPrecoVenda().setText(String.valueOf(presenter.getProduto().getPrecoVenda()));
    }

    @Override
    public String toString() {
        return "Visualização";
    }

}
