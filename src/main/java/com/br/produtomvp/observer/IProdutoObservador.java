package com.br.produtomvp.observer;

import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;

/**
 *
 * @author tetzner
 */
public interface IProdutoObservador {
     void atualizar(GerenciadorRepositoryProdutoService gerenciadorRepositoryProdutoService);
}
