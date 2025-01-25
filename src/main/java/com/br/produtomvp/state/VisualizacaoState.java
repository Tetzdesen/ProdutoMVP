/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.produtomvp.state;

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
        presenter.getViewInclusao().getBtnExcluir().addActionListener((ActionEvent e) -> {
            try {
                excluir();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(presenter.getViewInclusao(), ex.getMessage());
            }
        });

        presenter.getViewInclusao().getBtnEditar().addActionListener((ActionEvent e) -> {
            editar();
        });
        
         presenter.getViewInclusao().getBtnCancelar().addActionListener((ActionEvent e) -> {
            fechar();
        });
        
        habilitarComponentes();
    }

    private void habilitarComponentes() {
        presenter.getViewInclusao().getBtnEditar().setEnabled(true);
        presenter.getViewInclusao().getBtnExcluir().setEnabled(true);
        presenter.getViewInclusao().getBtnSalvar().setEnabled(false);
        presenter.getViewInclusao().getBtnCancelar().setEnabled(true);
        presenter.getViewInclusao().getTxtNome().setEnabled(true);
        presenter.getViewInclusao().getTxtPrecoCusto().setEnabled(true);
        presenter.getViewInclusao().getTxtPercentualLucro().setEnabled(true);
        presenter.getViewInclusao().getTxtPrecoVenda().setEnabled(true);
        presenter.getViewInclusao().getTxtNome().setEditable(false);
        presenter.getViewInclusao().getTxtPrecoCusto().setEditable(false);
        presenter.getViewInclusao().getTxtPercentualLucro().setEditable(false);
        presenter.getViewInclusao().getTxtPrecoVenda().setEditable(false);
    }

    @Override
    public void excluir() {
        int confirmacao = JOptionPane.showConfirmDialog(
                this.presenter.getViewInclusao(),
                "Deseja remover o produto selecionado?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            this.presenter.getGerenciadorRepositoryProdutoService().deletarProdutoPorID(presenter.getProduto().getIdProduto());
            JOptionPane.showMessageDialog(presenter.getViewInclusao(), "Produto excluido com sucesso");
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
        presenter.getViewInclusao().dispose();
    }

    @Override
    public String toString() {
        return "Visualização";
    }

}
