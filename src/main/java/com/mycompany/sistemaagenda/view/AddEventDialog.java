/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemaagenda.view;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.model.Event;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author pedrh
 */
public class AddEventDialog extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddEventDialog.class.getName());

    /**
     * Creates new form EditEventDialog
     */
    public AddEventDialog() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventDateLabel = new javax.swing.JLabel();
        eventDateFtf = new javax.swing.JFormattedTextField();
        eventSpeakerLabel = new javax.swing.JLabel();
        eventNameTf = new javax.swing.JTextField();
        eventNameLabel = new javax.swing.JLabel();
        eventSpeakerTf = new javax.swing.JTextField();
        eventRoomLabel = new javax.swing.JLabel();
        eventRoomTf = new javax.swing.JTextField();
        addEventBt = new javax.swing.JButton();
        cancelEditBt = new javax.swing.JButton();
        eventFeeLabel = new javax.swing.JLabel();
        eventFeeTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Evento");

        eventDateLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eventDateLabel.setText("Data e hora");

        try {
            eventDateFtf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        eventSpeakerLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eventSpeakerLabel.setText("Palestrante");

        eventNameTf.setPreferredSize(new java.awt.Dimension(64, 26));

        eventNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eventNameLabel.setText("Nome");

        eventSpeakerTf.setPreferredSize(new java.awt.Dimension(64, 26));
        eventSpeakerTf.addActionListener(this::eventSpeakerTfActionPerformed);

        eventRoomLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eventRoomLabel.setText("Sala");

        eventRoomTf.setPreferredSize(new java.awt.Dimension(64, 26));

        addEventBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addEventBt.setText("Adicionar");
        addEventBt.addActionListener(this::addEventBtActionPerformed);
        addEventBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addEventBtKeyPressed(evt);
            }
        });

        cancelEditBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelEditBt.setText("Cancelar");
        cancelEditBt.addActionListener(this::cancelEditBtActionPerformed);
        cancelEditBt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelEditBtKeyPressed(evt);
            }
        });

        eventFeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eventFeeLabel.setText("Inscrição");

        eventFeeTf.setPreferredSize(new java.awt.Dimension(64, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eventNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelEditBt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addEventBt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eventSpeakerTf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eventRoomTf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 31, Short.MAX_VALUE))
                                    .addComponent(eventRoomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eventFeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eventDateFtf)
                                    .addComponent(eventDateLabel)))
                            .addComponent(eventFeeTf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(eventSpeakerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(eventNameTf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(eventNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventSpeakerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventSpeakerTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(eventRoomTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eventDateLabel)
                            .addComponent(eventRoomLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventDateFtf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventFeeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eventFeeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addEventBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelEditBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventBtActionPerformed
        addEvent();
    }//GEN-LAST:event_addEventBtActionPerformed

    private void addEventBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addEventBtKeyPressed
        addEvent();
    }//GEN-LAST:event_addEventBtKeyPressed

    private void cancelEditBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditBtActionPerformed
        dispose();
    }//GEN-LAST:event_cancelEditBtActionPerformed

    private void cancelEditBtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelEditBtKeyPressed
        dispose();
    }//GEN-LAST:event_cancelEditBtKeyPressed

    private void eventSpeakerTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventSpeakerTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventSpeakerTfActionPerformed

    
    public void addEvent(){
        String name = eventNameTf.getText();
        String speaker = eventSpeakerTf.getText();
        String roomText = eventRoomTf.getText().trim();
        String feeText = eventFeeTf.getText().trim();
        int room;
        int fee;
        try{
            room = Integer.parseInt(roomText);
            fee = Integer.parseInt(feeText);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Os campos Sala e Inscrição devem ser valores numéricos.");
            return;
        }
        if(name.isEmpty() || speaker.isEmpty() || roomText.isEmpty() || feeText.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nenhum dos campos podem ser vazios.");
            return;
        }
        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(eventDateFtf.getText(), formatter);
        Event event = new Event(date, room, name, speaker, fee);
        EventDAO eventDAO = new EventDAO();
        try{
            eventDAO.createEvent(event);
            dispose();
        } catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao adicionar o evento.");
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AddEventDialog().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventBt;
    private javax.swing.JButton cancelEditBt;
    private javax.swing.JFormattedTextField eventDateFtf;
    private javax.swing.JLabel eventDateLabel;
    private javax.swing.JLabel eventFeeLabel;
    private javax.swing.JTextField eventFeeTf;
    private javax.swing.JLabel eventNameLabel;
    private javax.swing.JTextField eventNameTf;
    private javax.swing.JLabel eventRoomLabel;
    private javax.swing.JTextField eventRoomTf;
    private javax.swing.JLabel eventSpeakerLabel;
    private javax.swing.JTextField eventSpeakerTf;
    // End of variables declaration//GEN-END:variables
}
