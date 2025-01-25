package com.br.produtomvp.principal;

import com.br.produtomvp.factory.RepositoryFactory;
import com.br.produtomvp.presenter.PrincipalProdutoPresenter;
import com.br.produtomvp.repository.GerenciadorRepositoryProdutoService;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.br.produtomvp.repository.ProdutoRepository;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        
        configurarLinguagem();
        configurarLookAndFeel();
        
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String SGBD = dotenv.get("DB");
        RepositoryFactory daoFactory = RepositoryFactory.getRepositoryFactory(SGBD);
        ProdutoRepository produtoRepository = daoFactory.getProdutoRepository();
        GerenciadorRepositoryProdutoService repositoryProdutoService = new GerenciadorRepositoryProdutoService(produtoRepository);
        System.out.println(produtoRepository.buscarTodosProdutos());
        new PrincipalProdutoPresenter(repositoryProdutoService);
        
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

