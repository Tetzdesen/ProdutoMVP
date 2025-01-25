package com.br.produtomvp.factory;

import com.br.produtomvp.dao.ProdutoDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tetzner
 */
public abstract class DAOFactory {
    private static final Map<String, String> classMap = Map.of(
        "SQLite", "com.br.produtomvp.factory.SQLiteDAOFactory"
    );
    public abstract ProdutoDAO getProdutoDAO();
    
    public static DAOFactory getDAOFactory(String nomeClasseSGBD){
        DAOFactory daoFactory = null;
        String classeDB = classMap.get(nomeClasseSGBD);
        System.out.println(classeDB);
        try {
            Class<?> nomeClasse = Class.forName(classeDB);
            var construtor = nomeClasse.getConstructor();
            daoFactory = (DAOFactory) construtor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DAOFactory   .class.getName()).log(Level.SEVERE, null, ex);
        }
        return daoFactory;
    }
}
