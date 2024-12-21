package com.br.produtomvp.dao;

import com.br.produtomvp.model.Produto;
import java.util.List;
import java.util.UUID;

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
    
    public List<Produto> lerProdutos(){
        return produtoDAO.lerTodosProdutos();
    }
    
    public void atualizarProduto(Produto produto){
        produtoDAO.atualizarProduto(produto);
    }
    
    public void deletarProdutoPorID(int id){
        produtoDAO.deletarProdutoPorID(id);
    }
        
}
