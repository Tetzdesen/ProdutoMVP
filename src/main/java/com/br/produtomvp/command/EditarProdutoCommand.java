package com.br.produtomvp.command;

import com.br.produtomvp.model.Produto;
import com.br.produtomvp.presenter.ProdutoPresenter;
import com.br.produtomvp.state.VisualizacaoState;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public class EditarProdutoCommand implements IProdutoPresenterCommand {

    @Override
    public void executar(ProdutoPresenter presenter) {
        try {

            String nome = presenter.getView().getTxtNome().getText();
            double precoCusto = Double.parseDouble(presenter.getView().getTxtPrecoCusto().getText());
            double percentualLucro = Double.parseDouble(presenter.getView().getTxtPercentualLucro().getText());
            
            verificarCampos(nome, precoCusto, percentualLucro);
            
            Produto produto = new Produto(nome, precoCusto, percentualLucro);
            
            produto.setIdProduto(presenter.getProduto().getIdProduto());
            
            presenter.getGerenciadorRepositoryProdutoService().atualizarProduto(produto);
            
            presenter.getView().getTxtPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));

            JOptionPane.showMessageDialog(presenter.getView(), "Produto editado com sucesso");
            
            presenter.setProduto(produto);
            
            presenter.setState(new VisualizacaoState(presenter));
  
        } catch (NumberFormatException erroDeDados) {
            JOptionPane.showMessageDialog(presenter.getView(), "Favor informar dados válidos!" + erroDeDados);

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(presenter.getView(), erro.getMessage());
        }
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

}
