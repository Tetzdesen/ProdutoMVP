package com.br.produtomvp.observer;

import com.br.produtomvp.collection.ProdutoCollection;

/**
 *
 * @author tetzner
 */
public interface IProdutoObservador {
     void atualizar(ProdutoCollection produtoCollection);
}
