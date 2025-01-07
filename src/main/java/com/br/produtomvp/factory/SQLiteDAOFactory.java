package com.br.produtomvp.factory;

import com.br.produtomvp.dao.ProdutoDAO;
import com.br.produtomvp.dao.ProdutoDAOSQLite;

/**
 *
 * @author tetzner
 */
public class SQLiteDAOFactory extends DAOFactory{

    @Override
    public ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOSQLite();
    }
    
}
