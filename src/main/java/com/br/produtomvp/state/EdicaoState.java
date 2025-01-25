/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.produtomvp.state;

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

        presenter.getViewInclusao().getBtnSalvar().addActionListener((ActionEvent e) -> {
            try {
                salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(presenter.getViewInclusao(), ex.getMessage());
            }
        });

        presenter.getViewInclusao().getBtnCancelar().addActionListener((ActionEvent e) -> {
            cancelar();
        });
        preencherCampos();
        habilitarComponentes();

    }

    @Override
    public void salvar() {
        try {

            String nome = presenter.getViewInclusao().getTxtNome().getText();
            double precoCusto = Double.parseDouble(presenter.getViewInclusao().getTxtPrecoCusto().getText());
            double percentualLucro = Double.parseDouble(presenter.getViewInclusao().getTxtPercentualLucro().getText());
            verificarCampos(nome, precoCusto, percentualLucro);
            Produto produto = new Produto(nome, precoCusto, percentualLucro);
            produto.setIdProduto(presenter.getProduto().getIdProduto());
            presenter.getGerenciadorRepositoryProdutoService().atualizarProduto(produto);
            presenter.getViewInclusao().getTxtPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));

            JOptionPane.showMessageDialog(presenter.getViewInclusao(), "Produto editado com sucesso");
            // limparCampos();
            presenter.setProduto(produto);
            presenter.setState(new VisualizacaoState(presenter));
            //new VisualizacaoProdutoPresenter(produtoCollection, gerenciadorProduto).exibirProduto(produto);
        } catch (NumberFormatException erroDeDados) {
            JOptionPane.showMessageDialog(presenter.getViewInclusao(), "Favor informar dados válidos!" + erroDeDados);

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(presenter.getViewInclusao(), erro.getMessage());
        }
    }

    @Override
    public void cancelar() {
        presenter.getViewInclusao().dispose();
    }

    private void verificarCampos(String nome, double precoCusto, double percentualLucro) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório ");
        }
        if (precoCusto <= 0) {
            throw new IllegalArgumentException("Preço de custo deve ser maior que zero ");
        }
        if (percentualLucro <= 0) {
            throw new IllegalArgumentException("Percentual de lucro deve ser maior que zero ");
        }
    }

    private void habilitarComponentes() {
        presenter.getViewInclusao().getBtnSalvar().setEnabled(true);
        presenter.getViewInclusao().getBtnCancelar().setEnabled(true);
        presenter.getViewInclusao().getBtnEditar().setEnabled(false);
        presenter.getViewInclusao().getBtnExcluir().setEnabled(false);
        presenter.getViewInclusao().getTxtNome().setEnabled(true);
        presenter.getViewInclusao().getTxtPrecoCusto().setEnabled(true);
        presenter.getViewInclusao().getTxtPercentualLucro().setEnabled(true);
        presenter.getViewInclusao().getTxtPrecoVenda().setEnabled(true);
        presenter.getViewInclusao().getTxtNome().setEditable(true);
        presenter.getViewInclusao().getTxtPrecoCusto().setEditable(true);
        presenter.getViewInclusao().getTxtPercentualLucro().setEditable(true);
        presenter.getViewInclusao().getTxtPrecoVenda().setEditable(true);
    }

    private void preencherCampos() {
        presenter.getViewInclusao().getTxtNome().setText(presenter.getProduto().getNome());
        presenter.getViewInclusao().getTxtPrecoCusto().setText(String.valueOf(presenter.getProduto().getPrecoCusto()));
        presenter.getViewInclusao().getTxtPercentualLucro().setText(String.valueOf(presenter.getProduto().getPercentualLucro()));
        presenter.getViewInclusao().getTxtPrecoVenda().setText(String.valueOf(presenter.getProduto().getPrecoVenda()));
    }

    private void limparCampos() {
        presenter.getViewInclusao().getTxtNome().setText("");
        presenter.getViewInclusao().getTxtPrecoCusto().setText("");
        presenter.getViewInclusao().getTxtPercentualLucro().setText("");
        presenter.getViewInclusao().getTxtPrecoVenda().setText("");
    }

    @Override
    public String toString() {
        return "Edição";
    }
}
