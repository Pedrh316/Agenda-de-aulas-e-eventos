package com.mycompany.sistemaagenda.view;

import javax.swing.JOptionPane;
import com.mycompany.sistemaagenda.controller.LoginController;


public final class Login extends javax.swing.JFrame {    
    private LoginController lCtrl;
    
    public Login() {
        initComponents();
        errorLb.setVisible(false);
        setLocationRelativeTo(null);        
    }   

    public void setController(LoginController dbCtrl){
        this.lCtrl = dbCtrl;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLb = new javax.swing.JLabel();
        passwordLb = new javax.swing.JLabel();
        errorLb = new javax.swing.JLabel();
        emailTf = new javax.swing.JTextField();
        passwordPf = new javax.swing.JPasswordField();
        signUpBt = new javax.swing.JButton();
        loginBt = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        optionsMn = new javax.swing.JMenu();
        signUpMni = new javax.swing.JMenuItem();
        conMni = new javax.swing.JMenuItem();
        closeMni = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu login");

        emailLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emailLb.setText("Email:");

        passwordLb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        passwordLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLb.setText("Senha:");

        errorLb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorLb.setForeground(new java.awt.Color(255, 0, 0));
        errorLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        errorLb.setText("Email ou senha incorretos");

        emailTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTf.setToolTipText("");
        emailTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTfKeyPressed(evt);
            }
        });

        passwordPf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordPf.setToolTipText("");
        passwordPf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordPfKeyPressed(evt);
            }
        });

        signUpBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpBt.setText("Cadastrar-se");
        signUpBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtActionPerformed(evt);
            }
        });
        signUpBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                signUpBtKeyPressed(evt);
            }
        });

        loginBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loginBt.setText("Entrar");
        loginBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtActionPerformed(evt);
            }
        });
        loginBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtKeyPressed(evt);
            }
        });

        optionsMn.setText("Opções");
        optionsMn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        signUpMni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpMni.setText("Cadastrar-se...");
        signUpMni.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        signUpMni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpMniActionPerformed(evt);
            }
        });
        optionsMn.add(signUpMni);

        conMni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        conMni.setText("Conectar-se...");
        conMni.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        conMni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conMniActionPerformed(evt);
            }
        });
        optionsMn.add(conMni);

        closeMni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        closeMni.setText("Fechar aplicação");
        closeMni.setAlignmentX(0.6F);
        closeMni.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        closeMni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMniActionPerformed(evt);
            }
        });
        optionsMn.add(closeMni);

        mnBar.add(optionsMn);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(passwordPf)
                            .addComponent(emailTf)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signUpBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtActionPerformed
        signUp();
    }//GEN-LAST:event_signUpBtActionPerformed

    private void loginBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtActionPerformed
        login();
    }//GEN-LAST:event_loginBtActionPerformed

    private void signUpMniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpMniActionPerformed
        signUp();
    }//GEN-LAST:event_signUpMniActionPerformed

    private void closeMniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMniActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeMniActionPerformed

    private void emailTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTfKeyPressed
        login(evt);
    }//GEN-LAST:event_emailTfKeyPressed

    private void passwordPfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPfKeyPressed
        login(evt);
    }//GEN-LAST:event_passwordPfKeyPressed

    private void loginBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtKeyPressed
        login(evt);
    }//GEN-LAST:event_loginBtKeyPressed

    private void signUpBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpBtKeyPressed
        signUp(evt);
    }//GEN-LAST:event_signUpBtKeyPressed

    private void conMniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conMniActionPerformed
        lCtrl.dbCon();
    }//GEN-LAST:event_conMniActionPerformed

    public void login(){
        emailTf.setText(emailTf.getText().replaceAll("\\s+", ""));              
        lCtrl.login(emailTf.getText(), String.valueOf(passwordPf.getPassword()));        
    }
    public void login(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) login();
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void loginError(){
        errorLb.setVisible(true);
    }
    public void loginSuccess(){
        passwordPf.setText("");
        errorLb.setVisible(false);
    }
    
    public void signUp(){
        //setVisible(false);
        //rtErro.setVisible(false);
        //navegador.mostrarJCadastro();
    }
    public void signUp(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) signUp();
    }   
    
        
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeMni;
    private javax.swing.JMenuItem conMni;
    private javax.swing.JLabel emailLb;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel errorLb;
    private javax.swing.JButton loginBt;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu optionsMn;
    private javax.swing.JLabel passwordLb;
    private javax.swing.JPasswordField passwordPf;
    private javax.swing.JButton signUpBt;
    private javax.swing.JMenuItem signUpMni;
    // End of variables declaration//GEN-END:variables

    
}
