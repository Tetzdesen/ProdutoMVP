package com.br.produtomvp.view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author tetzner
 */
public final class ProdutoView extends javax.swing.JFrame {

    /**
     * Creates new form InclusaoProdutoView
     */
    public ProdutoView() {
        initComponents();
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }
    
    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtPercentualLucro() {
        return txtPercentualLucro;
    }

    public JTextField getTxtPrecoCusto() {
        return txtPrecoCusto;
    }

    public JTextField getTxtPrecoVenda() {
        return txtPrecoVenda;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblPrecoCusto = new javax.swing.JLabel();
        lblPercentualLucro = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPrecoCusto = new javax.swing.JTextField();
        txtPercentualLucro = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manter produto");
        setResizable(false);

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setText("Nome");

        lblPrecoCusto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPrecoCusto.setText("Preço de Custo");
        lblPrecoCusto.setToolTipText("");

        lblPercentualLucro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPercentualLucro.setText("Percentual de Lucro");

        lblPrecoVenda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPrecoVenda.setText("Preço de Venda");

        txtPrecoVenda.setEditable(false);
        txtPrecoVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnExcluir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("");
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnEditar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setText("Fechar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblPrecoCusto))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtPrecoCusto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPercentualLucro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecoVenda, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecoVenda)
                                    .addComponent(txtPercentualLucro))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrecoCusto)
                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPercentualLucro)
                    .addComponent(txtPercentualLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblPrecoVenda))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPercentualLucro;
    private javax.swing.JLabel lblPrecoCusto;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPercentualLucro;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JTextField txtPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
