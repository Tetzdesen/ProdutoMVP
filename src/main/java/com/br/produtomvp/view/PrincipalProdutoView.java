package com.br.produtomvp.view;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author tetzner
 */
public final class PrincipalProdutoView extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalView
     */
    public PrincipalProdutoView() {
        initComponents();
    }

    public JMenuItem getMnuItemIncluir() {
        return mnuItemIncluir;
    }

    public JMenuItem getMnuItemBuscarProdutos() {
        return mnuItemBuscarProdutos;
    } 

    public JLabel getLblQuantidadeProdutos() {
        return lblQuantidadeProdutos;
    }
    
    public JRadioButtonMenuItem getMnuRadioJSON() {
        return mnuRadioJSON;
    }

    public JRadioButtonMenuItem getMnuRadioXML() {
        return mnuRadioXML;
    }

    public JRadioButtonMenuItem getMnuRadioSQLite() {
        return mnuRadioSQLite;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotalProdutos = new javax.swing.JLabel();
        lblQuantidadeProdutos = new javax.swing.JLabel();
        mnuBarProduto = new javax.swing.JMenuBar();
        mnuProduto = new javax.swing.JMenu();
        mnuItemIncluir = new javax.swing.JMenuItem();
        mnuItemBuscarProdutos = new javax.swing.JMenuItem();
        mnuGerenciarLog = new javax.swing.JMenu();
        mnuRadioJSON = new javax.swing.JRadioButtonMenuItem();
        mnuRadioXML = new javax.swing.JRadioButtonMenuItem();
        mnuDB = new javax.swing.JMenu();
        mnuRadioSQLite = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal de Produto");
        setResizable(false);

        lblTotalProdutos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTotalProdutos.setText("Total de produtos:");

        lblQuantidadeProdutos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblQuantidadeProdutos.setText("0");

        mnuBarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        mnuProduto.setText("Produto");

        mnuItemIncluir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuItemIncluir.setText("Incluir");
        mnuProduto.add(mnuItemIncluir);

        mnuItemBuscarProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuItemBuscarProdutos.setText("Buscar");
        mnuProduto.add(mnuItemBuscarProdutos);

        mnuBarProduto.add(mnuProduto);

        mnuGerenciarLog.setText("Configurar Log");

        mnuRadioJSON.setText("JSON");
        mnuGerenciarLog.add(mnuRadioJSON);

        mnuRadioXML.setText("XML");
        mnuGerenciarLog.add(mnuRadioXML);

        mnuDB.setText("DB");

        mnuRadioSQLite.setText("SQLite");
        mnuDB.add(mnuRadioSQLite);

        mnuGerenciarLog.add(mnuDB);

        mnuBarProduto.add(mnuGerenciarLog);

        setJMenuBar(mnuBarProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(lblTotalProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuantidadeProdutos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadeProdutos)
                    .addComponent(lblTotalProdutos)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblQuantidadeProdutos;
    private javax.swing.JLabel lblTotalProdutos;
    private javax.swing.JMenuBar mnuBarProduto;
    private javax.swing.JMenu mnuDB;
    private javax.swing.JMenu mnuGerenciarLog;
    private javax.swing.JMenuItem mnuItemBuscarProdutos;
    private javax.swing.JMenuItem mnuItemIncluir;
    private javax.swing.JMenu mnuProduto;
    private javax.swing.JRadioButtonMenuItem mnuRadioJSON;
    private javax.swing.JRadioButtonMenuItem mnuRadioSQLite;
    private javax.swing.JRadioButtonMenuItem mnuRadioXML;
    // End of variables declaration//GEN-END:variables
}
