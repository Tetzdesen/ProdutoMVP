package com.br.produtomvp.dao;

import com.br.produtomvp.model.Produto;
import java.util.List;

/**
 *
 * @author tetzner
 */
public class GerenciadorProdutoService {
    private final ProdutoDAO produtoDAO;

    public GerenciadorProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
    public void adicionarProduto(Produto produto){
        produtoDAO.criarProduto(produto);
    }
    
    public List<Produto> buscarProdutos(){
        return produtoDAO.buscarTodosProdutos();
    }
    
    public void atualizarProduto(Produto produto){
        produtoDAO.atualizarProduto(produto);
    }
    
    public void deletarProdutoPorID(int id){
        produtoDAO.deletarProdutoPorID(id);
    }
        
}
