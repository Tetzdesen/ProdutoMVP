package com.br.produtomvp.principal;

import com.br.produtomvp.collection.ProdutoCollection;
import com.br.produtomvp.dao.ProdutoDAO;
import com.br.produtomvp.dao.ProdutoDAOSQLite;
import com.br.produtomvp.factory.DAOFactory;
import com.br.produtomvp.presenter.PrincipalProdutoPresenter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        configurarLinguagem();
        configurarLookAndFeel();    
        
    //    DAOFactory daoFactory  = DAOFactory.getDAOFactory("com.br.produtomvp.factory.SQLiteDAOFactory");
   //     ProdutoDAO produtoDAO = daoFactory.getProdutoDAO();
      //  System.out.println(produtoDAO.buscarTodosProdutos());
      ProdutoCollection produtoCollection = new ProdutoCollection();
      new PrincipalProdutoPresenter(produtoCollection);
    }

    private static void configurarLinguagem() {
        Locale.setDefault(new Locale("pt", "BR"));
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
    }

    private static void configurarLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao configurar Look and Feel: " + ex.getMessage());
        }
    }
}
