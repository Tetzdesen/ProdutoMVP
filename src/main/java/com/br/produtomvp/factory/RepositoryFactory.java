package com.br.produtomvp.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.br.produtomvp.repository.ProdutoRepository;

/**
 *
 * @author tetzner
 */
public abstract class RepositoryFactory {
    private static final Map<String, String> classMap = Map.of(
        "SQLite", "com.br.produtomvp.factory.SQLiteRepositoryFactory"
    );
    public abstract ProdutoRepository getProdutoRepository();
    
    public static RepositoryFactory getRepositoryFactory(String nomeClasseSGBD){
        RepositoryFactory daoFactory = null;
        String classeDB = classMap.get(nomeClasseSGBD);
        System.out.println(classeDB);
        try {
            Class<?> nomeClasse = Class.forName(classeDB);
            var construtor = nomeClasse.getConstructor();
            daoFactory = (RepositoryFactory) construtor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(RepositoryFactory   .class.getName()).log(Level.SEVERE, null, ex);
        }
        return daoFactory;
    }
}
