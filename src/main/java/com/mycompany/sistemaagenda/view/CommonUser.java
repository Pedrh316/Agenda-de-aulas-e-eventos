package com.mycompany.sistemaagenda.view;

import com.mycompany.sistemaagenda.controller.CommonUserController;
import com.mycompany.sistemaagenda.model.Event;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CommonUser extends javax.swing.JFrame {
    private CommonUserController ctrl;   
    
    public CommonUser() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setController(CommonUserController ctrl){
        this.ctrl = ctrl;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        userTabPanel = new javax.swing.JPanel();
        welcomeLb = new javax.swing.JLabel();
        availableEventsBt = new javax.swing.JButton();
        userEventsBt = new javax.swing.JButton();
        logoutBt = new javax.swing.JButton();
        availableEventsTabPanel = new javax.swing.JPanel();
        availableEventsTableSP = new javax.swing.JScrollPane();
        availableEventsTable = new javax.swing.JTable();
        availableEventsLb = new javax.swing.JLabel();
        userEventsTabPanel = new javax.swing.JPanel();
        userEventsLb = new javax.swing.JLabel();
        userEventsTableSP = new javax.swing.JScrollPane();
        userEventsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPane.addChangeListener(this::tabPaneStateChanged);

        welcomeLb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        welcomeLb.setText("Olá,");

        availableEventsBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        availableEventsBt.setText("Eventos Disponíveis");
        availableEventsBt.addActionListener(this::availableEventsBtActionPerformed);

        userEventsBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userEventsBt.setText("Eventos Cadastrados");
        userEventsBt.addActionListener(this::userEventsBtActionPerformed);

        logoutBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBt.setText("Sair");
        logoutBt.addActionListener(this::logoutBtActionPerformed);

        javax.swing.GroupLayout userTabPanelLayout = new javax.swing.GroupLayout(userTabPanel);
        userTabPanel.setLayout(userTabPanelLayout);
        userTabPanelLayout.setHorizontalGroup(
            userTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTabPanelLayout.createSequentialGroup()
                .addGroup(userTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userTabPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(welcomeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addGap(440, 440, 440))
                    .addGroup(userTabPanelLayout.createSequentialGroup()
                        .addContainerGap(329, Short.MAX_VALUE)
                        .addGroup(userTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userEventsBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(availableEventsBt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(332, 332, 332))
        );
        userTabPanelLayout.setVerticalGroup(
            userTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTabPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(welcomeLb)
                .addGap(40, 40, 40)
                .addComponent(availableEventsBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userEventsBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutBt)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        tabPane.addTab("Usuário", userTabPanel);

        availableEventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evento", "Palestrante", "Sala", "Data", "Horário", "Inscrição"
            }
        ));
        availableEventsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableEventsTableMouseClicked(evt);
            }
        });
        availableEventsTableSP.setViewportView(availableEventsTable);

        availableEventsLb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        availableEventsLb.setText("Eventos Disponíveis");

        javax.swing.GroupLayout availableEventsTabPanelLayout = new javax.swing.GroupLayout(availableEventsTabPanel);
        availableEventsTabPanel.setLayout(availableEventsTabPanelLayout);
        availableEventsTabPanelLayout.setHorizontalGroup(
            availableEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableEventsTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(availableEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableEventsTableSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(availableEventsTabPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(availableEventsLb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        availableEventsTabPanelLayout.setVerticalGroup(
            availableEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, availableEventsTabPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(availableEventsLb)
                .addGap(28, 28, 28)
                .addComponent(availableEventsTableSP, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        tabPane.addTab("Eventos", availableEventsTabPanel);

        userEventsLb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userEventsLb.setText("Suas Inscrições");

        userEventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evento", "Palestrante", "Sala", "Data", "Horário", "Inscrição"
            }
        ));
        userEventsTableSP.setViewportView(userEventsTable);

        javax.swing.GroupLayout userEventsTabPanelLayout = new javax.swing.GroupLayout(userEventsTabPanel);
        userEventsTabPanel.setLayout(userEventsTabPanelLayout);
        userEventsTabPanelLayout.setHorizontalGroup(
            userEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userEventsTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userEventsTableSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(userEventsTabPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userEventsLb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userEventsTabPanelLayout.setVerticalGroup(
            userEventsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userEventsTabPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(userEventsLb)
                .addGap(28, 28, 28)
                .addComponent(userEventsTableSP, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        tabPane.addTab("Inscrições", userEventsTabPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );

        tabPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtActionPerformed
        ctrl.logout();
    }//GEN-LAST:event_logoutBtActionPerformed

    private void availableEventsBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableEventsBtActionPerformed
        ctrl.avalEventsBt();
    }//GEN-LAST:event_availableEventsBtActionPerformed

    private void userEventsBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEventsBtActionPerformed
        ctrl.userEventsBt();
    }//GEN-LAST:event_userEventsBtActionPerformed

    private void tabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPaneStateChanged
        if(ctrl!=null) ctrl.tabSelected(tabPane.getSelectedIndex());
    }//GEN-LAST:event_tabPaneStateChanged

    private void availableEventsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableEventsTableMouseClicked
        tableItemSelected(availableEventsTable);
    }//GEN-LAST:event_availableEventsTableMouseClicked
    
    private void tableItemSelected(JTable table){
        int line = table.getSelectedRow();
        if(line < 0) return;
        
        ctrl.tableItemSelected(
                (int) table.getModel().getValueAt(line, 2),
                LocalDate.parse(
                    table.getModel().getValueAt(line, 3).toString(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                ),
                LocalTime.parse(
                    table.getModel().getValueAt(line, 4).toString(),
                    DateTimeFormatter.ofPattern("HH:mm")
                )
        );
    }
    
    public void setTab(int index){
        tabPane.setSelectedIndex(index);
    }
    
    public void updateTable(JTable table, List<Event> events){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        int lin = 0;
        model.setRowCount(lin);
        
        for(Event e : events){
            model.insertRow(lin, new Object[]{
                e.getName(),
                e.getSpeaker(), 
                e.getRoom(),
                e.getDate().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                e.getDate().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                e.getFee()
            });
            lin++;
        }
    }
    
    public void showErrorMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void showInfoMsg(String msg, String title){        
        JOptionPane.showMessageDialog(
           this,
           msg,
           title,
           JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public boolean showQuenstionMsg(String msg, String title){        
        return JOptionPane.showConfirmDialog(
                this,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0;
    }
    
    public void setWelcomeLbText(String text){
        welcomeLb.setText(text);
    }
    
    public JTable getAvailableEventsTable(){
        return availableEventsTable;
    }

    public JTable getUserEventsTable(){
        return userEventsTable;
    }
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CommonUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton availableEventsBt;
    private javax.swing.JLabel availableEventsLb;
    private javax.swing.JPanel availableEventsTabPanel;
    private javax.swing.JTable availableEventsTable;
    private javax.swing.JScrollPane availableEventsTableSP;
    private javax.swing.JButton logoutBt;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JButton userEventsBt;
    private javax.swing.JLabel userEventsLb;
    private javax.swing.JPanel userEventsTabPanel;
    private javax.swing.JTable userEventsTable;
    private javax.swing.JScrollPane userEventsTableSP;
    private javax.swing.JPanel userTabPanel;
    private javax.swing.JLabel welcomeLb;
    // End of variables declaration//GEN-END:variables
}
