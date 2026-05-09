package com.mycompany.sistemaagenda.view;

import com.github.weisj.darklaf.*;
import com.mycompany.sistemaagenda.controller.SignUpController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SignUp extends javax.swing.JFrame {
    private SignUpController suCtrl;
    
    public SignUp() {       
        initComponents();                        
        setLocationRelativeTo(null);
    }
    
    public void setController(SignUpController suCtrl){
        this.suCtrl = suCtrl;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLb = new javax.swing.JLabel();
        nameLb = new javax.swing.JLabel();
        passwordLb = new javax.swing.JLabel();
        cpasswordLb = new javax.swing.JLabel();
        emailTf = new javax.swing.JTextField();
        nameTf = new javax.swing.JTextField();
        passwordPf = new javax.swing.JPasswordField();
        cpasswordPf = new javax.swing.JPasswordField();
        returnBt = new javax.swing.JButton();
        confirmBt = new javax.swing.JButton();
        titleLb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");

        emailLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emailLb.setText("Email:");

        nameLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nameLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLb.setText("Nome:");

        passwordLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        passwordLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLb.setText("Senha:");

        cpasswordLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cpasswordLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cpasswordLb.setText("Confirmar senha:");

        emailTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTfFocusLost(evt);
            }
        });
        emailTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTfKeyPressed(evt);
            }
        });

        nameTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTfFocusLost(evt);
            }
        });
        nameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTfKeyPressed(evt);
            }
        });

        passwordPf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordPf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordPfKeyPressed(evt);
            }
        });

        cpasswordPf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpasswordPf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpasswordPfKeyPressed(evt);
            }
        });

        returnBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        returnBt.setText("Voltar");
        returnBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtActionPerformed(evt);
            }
        });
        returnBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnBtKeyPressed(evt);
            }
        });

        confirmBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        confirmBt.setText("Confirmar");
        confirmBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtActionPerformed(evt);
            }
        });
        confirmBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmBtKeyPressed(evt);
            }
        });

        titleLb.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        titleLb.setText("Criar Conta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(returnBt)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpasswordLb, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(passwordLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cpasswordPf, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(passwordPf))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailTf, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(nameTf)))
                            .addComponent(confirmBt))
                        .addContainerGap(136, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(titleLb)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpasswordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpasswordPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(confirmBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(returnBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void returnBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtActionPerformed
        suCtrl.goBack();
    }//GEN-LAST:event_returnBtActionPerformed

    private void confirmBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtActionPerformed
        signUp();        
    }//GEN-LAST:event_confirmBtActionPerformed

    private void confirmBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmBtKeyPressed
        signUp(evt);
    }//GEN-LAST:event_confirmBtKeyPressed

    private void emailTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTfKeyPressed
        signUp(evt);
    }//GEN-LAST:event_emailTfKeyPressed

    private void nameTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTfKeyPressed
        signUp(evt);
    }//GEN-LAST:event_nameTfKeyPressed

    private void cpasswordPfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpasswordPfKeyPressed
        signUp(evt);
    }//GEN-LAST:event_cpasswordPfKeyPressed

    private void returnBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnBtKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) suCtrl.goBack();
    }//GEN-LAST:event_returnBtKeyPressed

    private void emailTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTfFocusLost
        emailTf.setText(emailTf.getText().replaceAll("\\s+", ""));
    }//GEN-LAST:event_emailTfFocusLost

    private void nameTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTfFocusLost
        nameTf.setText(nameTf.getText().trim());
    }//GEN-LAST:event_nameTfFocusLost

    private void passwordPfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPfKeyPressed
        signUp(evt);
    }//GEN-LAST:event_passwordPfKeyPressed
        
    public void signUp(){
        emailTf.setText(emailTf.getText().replaceAll("\\s+", ""));
        nameTf.setText(nameTf.getText().trim());
        
        suCtrl.SignUp(
                emailTf.getText(), 
                nameTf.getText(),
                String.valueOf(passwordPf.getPassword()),
                String.valueOf(cpasswordPf.getPassword())
        );
    }
    public void signUp(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) signUp();
    }  
    
    public void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );                
    }
    
    public void clear(){        
        emailTf.setText("");
        nameTf.setText("");
        passwordPf.setText("");
        cpasswordPf.setText("");
        emailTf.requestFocus();
    }        
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */        
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {        
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
        //catch (ClassNotFoundException e) {}
        //catch (InstantiationException e) {}
        //catch (IllegalAccessException e) {}        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBt;
    private javax.swing.JLabel cpasswordLb;
    private javax.swing.JPasswordField cpasswordPf;
    private javax.swing.JLabel emailLb;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel nameLb;
    private javax.swing.JTextField nameTf;
    private javax.swing.JLabel passwordLb;
    private javax.swing.JPasswordField passwordPf;
    private javax.swing.JButton returnBt;
    private javax.swing.JLabel titleLb;
    // End of variables declaration//GEN-END:variables
}
