/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
