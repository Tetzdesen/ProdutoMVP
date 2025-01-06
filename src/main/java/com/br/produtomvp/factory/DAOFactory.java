/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.produtomvp.factory;

import com.br.produtomvp.dao.ProdutoDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tetzner
 */
public abstract class DAOFactory {
    public abstract ProdutoDAO getProdutoDAO();
    
    public static DAOFactory getDAOFactory(String nomeClasseSGBD){
        try {
            Class<?> nomeClasse = Class.forName(nomeClasseSGBD);
            var construtor = nomeClasse.getConstructor();
            return (DAOFactory) construtor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
