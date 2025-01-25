package com.br.produtomvp.repository;

import com.br.produtomvp.model.Produto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tetzner
 */
public interface ProdutoRepository {
    void criarProduto(Produto produto);
    Optional<Produto> buscarProdutoPorID(int id);
    Optional<Produto> buscarProdutoPorNome(String nome);
    List<Produto> buscarTodosProdutos();
    void atualizarProduto(Produto produto);
    void deletarProdutoPorID(int id);
}
