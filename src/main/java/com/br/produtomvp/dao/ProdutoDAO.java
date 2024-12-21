package com.br.produtomvp.dao;

import com.br.produtomvp.model.Produto;
import java.util.List;

/**
 *
 * @author tetzner
 */
public interface ProdutoDAO {
    void criarProduto(Produto produto);
    Produto lerProdutoPorID(int id);
    List<Produto> lerTodosProdutos();
    void atualizarProduto(Produto produto);
    void deletarProdutoPorID(int id);
}
