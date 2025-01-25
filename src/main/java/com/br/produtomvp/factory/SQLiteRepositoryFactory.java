package com.br.produtomvp.factory;

import com.br.produtomvp.repository.ProdutoRepositorySQLite;
import com.br.produtomvp.repository.ProdutoRepository;

/**
 *
 * @author tetzner
 */
public class SQLiteRepositoryFactory extends RepositoryFactory{

    @Override
    public ProdutoRepository getProdutoRepository() {
        return new ProdutoRepositorySQLite();
    }
    
}
