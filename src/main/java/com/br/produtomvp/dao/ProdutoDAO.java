package com.br.produtomvp.dao;

import com.br.produtomvp.model.Produto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tetzner
 */
public interface ProdutoDAO {
    void criarProduto(Produto produto);
    Optional<Produto> buscarProdutoPorID(int id);
    List<Produto> buscarTodosProdutos();
    void atualizarProduto(Produto produto);
    void deletarProdutoPorID(int id);
}
