package com.mycompany.sistemaagenda.view;

import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import com.mycompany.sistemaagenda.controller.DatabaseController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class DbConnection extends javax.swing.JFrame {        
    
    public DbConnection() {        
        initComponents();
        setLocationRelativeTo(null);                  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLb = new javax.swing.JLabel();
        passwordLb = new javax.swing.JLabel();
        urlLb = new javax.swing.JLabel();
        titleLb = new javax.swing.JLabel();
        urlTf = new javax.swing.JTextField();
        userTf = new javax.swing.JTextField();
        passwordPf = new javax.swing.JPasswordField();
        connectBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexão");

        userLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userLb.setText("Usuário:");

        passwordLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        passwordLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLb.setText("Senha:");

        urlLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        urlLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        urlLb.setText("URL:");

        titleLb.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        titleLb.setText("Conecte-se ao BD");

        urlTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        urlTf.setToolTipText("");
        urlTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                urlTfKeyPressed(evt);
            }
        });

        userTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTf.setToolTipText("");
        userTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTfKeyPressed(evt);
            }
        });

        passwordPf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordPf.setToolTipText("");
        passwordPf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordPfKeyPressed(evt);
            }
        });

        connectBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        connectBt.setText("Confirmar");
        connectBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtActionPerformed(evt);
            }
        });
        connectBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                connectBtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(connectBt)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(urlLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(urlTf, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(userTf)
                            .addComponent(passwordPf)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(titleLb)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(titleLb)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(connectBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtActionPerformed
        connect();
    }//GEN-LAST:event_connectBtActionPerformed

    private void connectBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_connectBtKeyPressed
        connect(evt);
    }//GEN-LAST:event_connectBtKeyPressed

    private void urlTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTfKeyPressed
        connect(evt);
    }//GEN-LAST:event_urlTfKeyPressed

    private void userTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTfKeyPressed
        connect(evt);
    }//GEN-LAST:event_userTfKeyPressed

    private void passwordPfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPfKeyPressed
        connect(evt);
    }//GEN-LAST:event_passwordPfKeyPressed

    
    private void connect(){
        try {
            DatabaseController dbCtrl = new DatabaseController();            
            dbCtrl.connect(
                    urlTf.getText(), 
                    userTf.getText(), 
                    String.valueOf(passwordPf.getPassword())
            );
            
            JOptionPane.showMessageDialog(null, "Conexão bem-sucedida!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar ao banco de dados:\n" + e,
                "Erro de Conexão",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
    }
    private void connect(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) connect();
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DbConnection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectBt;
    private javax.swing.JLabel passwordLb;
    private javax.swing.JPasswordField passwordPf;
    private javax.swing.JLabel titleLb;
    private javax.swing.JLabel urlLb;
    private javax.swing.JTextField urlTf;
    private javax.swing.JLabel userLb;
    private javax.swing.JTextField userTf;
    // End of variables declaration//GEN-END:variables
}
