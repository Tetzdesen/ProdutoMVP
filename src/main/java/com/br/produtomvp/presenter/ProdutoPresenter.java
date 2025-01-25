package com.br.produtomvp.presenter;

import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;
import com.br.produtomvp.model.Produto;
import com.br.produtomvp.view.ProdutoView;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author tetzner
 */
public final class ProdutoPresenter {

    private final ProdutoView viewInclusao;
    private final GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService;
    
    public ProdutoPresenter(Produto produto, GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService) {
      //  if (produto == null) {
          //  throw new IllegalArgumentException("Produto Collection é nulo/invalido ");
       // }
        this.gerenciadorRepositoryProdutoService = gerenciadorRepositoryProdutoService;
        this.viewInclusao = new ProdutoView();
        configuraView();
    }

    private void configuraView() {
        this.viewInclusao.setVisible(false);
        configurarListeners();
        viewInclusao.setLocationRelativeTo(null);
        this.viewInclusao.setVisible(true);
    }

    private void configurarListeners() {
        this.viewInclusao.getBtnSalvar().addActionListener((ActionEvent e) -> {
            try {
                salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewInclusao, ex.getMessage());
            }
        });

        this.viewInclusao.getBtnCancelar().addActionListener((ActionEvent e) -> {
            cancelar();
        });
    }

    private void salvar() throws Exception {
        
        try {
            String nome = viewInclusao.getTxtNome().getText();
            double precoCusto = Double.parseDouble(viewInclusao.getTxtPrecoCusto().getText());
            double percentualLucro = Double.parseDouble(viewInclusao.getTxtPercentualLucro().getText());
            verificarCampos(nome, precoCusto, percentualLucro);
            Produto produto = new Produto(nome, precoCusto, percentualLucro);
            gerenciadorRepositoryProdutoService.adicionarProduto(produto);
            this.viewInclusao.getTxtPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));     
            JOptionPane.showMessageDialog(viewInclusao, "Produto incluido com sucesso");
            limparCampos();
            cancelar();
            //new VisualizacaoProdutoPresenter(produtoCollection, gerenciadorProduto).exibirProduto(produto);
        } catch (ParseException | NumberFormatException erroDeDados) {
            JOptionPane.showMessageDialog(viewInclusao, "Favor informar dados válidos!" + erroDeDados);

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(viewInclusao, erro.getMessage());
        }

    }

    private void cancelar() {
        viewInclusao.dispose();
    }

    private void verificarCampos(String nome, double precoCusto, double percentualLucro) throws Exception {
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome do produto é obrigatório ");
        }
        if (precoCusto <= 0) {
            throw new Exception("Preço de custo deve ser maior que zero ");
        }
        if (percentualLucro <= 0) {
            throw new Exception("Percentual de lucro deve ser maior que zero ");
        }
    }

    private void limparCampos() {
        this.viewInclusao.getTxtNome().setText("");
        this.viewInclusao.getTxtPrecoCusto().setText("");
        this.viewInclusao.getTxtPercentualLucro().setText("");
        this.viewInclusao.getTxtPrecoVenda().setText("");
    }
    
    
    
}
