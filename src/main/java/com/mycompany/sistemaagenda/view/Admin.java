package com.mycompany.sistemaagenda.view;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin extends javax.swing.JFrame {    
    List<User> users;
    List<Event> events;
    Event selectedEvent;
    User selectedUser;
    
    public Admin() {
        initComponents();
        users = loadUsers();
        events = loadEvents();
        loadUsersOnTable();
        loadEventsOnTable();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addEventBt = new javax.swing.JButton();
        deleteUserBt = new javax.swing.JButton();
        editEventBt = new javax.swing.JButton();
        userSp = new javax.swing.JScrollPane();
        userTb = new javax.swing.JTable();
        eventSp = new javax.swing.JScrollPane();
        eventTb = new javax.swing.JTable();
        loadParticipantsBt = new javax.swing.JButton();
        deleteEventBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setPreferredSize(new java.awt.Dimension(700, 423));

        addEventBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addEventBt.setText("Adicionar Evento");
        addEventBt.setMaximumSize(new java.awt.Dimension(107, 29));
        addEventBt.setMinimumSize(new java.awt.Dimension(107, 29));
        addEventBt.setPreferredSize(new java.awt.Dimension(161, 49));
        addEventBt.addActionListener(this::addEventBtActionPerformed);

        deleteUserBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteUserBt.setText("Excluir Usuário");
        deleteUserBt.addActionListener(this::deleteUserBtActionPerformed);

        editEventBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        editEventBt.setText("Editar Evento");
        editEventBt.addActionListener(this::editEventBtActionPerformed);

        userTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuários"
            }
        ));
        userTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTbMouseClicked(evt);
            }
        });
        userSp.setViewportView(userTb);

        eventTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Eventos"
            }
        ));
        eventTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventTbMouseClicked(evt);
            }
        });
        eventSp.setViewportView(eventTb);

        loadParticipantsBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loadParticipantsBt.setText("Ver Participantes");
        loadParticipantsBt.addActionListener(this::loadParticipantsBtActionPerformed);

        deleteEventBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteEventBt.setText("Excluir Evento");
        deleteEventBt.addActionListener(this::deleteEventBtActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEventBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteUserBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadParticipantsBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editEventBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteEventBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(eventSp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userSp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addEventBt, deleteUserBt, editEventBt, loadParticipantsBt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addEventBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editEventBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loadParticipantsBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteUserBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteEventBt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addEventBt, deleteEventBt, deleteUserBt, editEventBt, loadParticipantsBt});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventBtActionPerformed
        addEvent();
    }//GEN-LAST:event_addEventBtActionPerformed

    private void deleteUserBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtActionPerformed
        deleteUser();
    }//GEN-LAST:event_deleteUserBtActionPerformed

    private void loadParticipantsBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadParticipantsBtActionPerformed
        loadParticipants();
    }//GEN-LAST:event_loadParticipantsBtActionPerformed

    private void editEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEventBtActionPerformed
        editEvent();
    }//GEN-LAST:event_editEventBtActionPerformed

    private void userTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTbMouseClicked
        int linha = userTb.getSelectedRow();
        selectedUser = users.get(linha);
    }//GEN-LAST:event_userTbMouseClicked

    private void eventTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventTbMouseClicked
        int linha = eventTb.getSelectedRow();
        selectedEvent = events.get(linha);
    }//GEN-LAST:event_eventTbMouseClicked

    private void deleteEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventBtActionPerformed
        deleteEvent();
    }//GEN-LAST:event_deleteEventBtActionPerformed

    private void addEvent(){
        AddEventDialog view = new AddEventDialog(this);
        view.setVisible(true);
    }
    private void editEvent(){
        EditEventDialog editEventDialog = new EditEventDialog(this, selectedEvent);
        editEventDialog.setVisible(true);
    }
    private void deleteUser(){
        UserDAO userDAO = new UserDAO();
        try{
            userDAO.deleteUser(selectedUser);
            users = loadUsers();
            loadUsersOnTable();
        } catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o usuário selecionado");
        }
    }
    private void deleteEvent(){
        if(selectedEvent != null){
            EventDAO eventDAO = new EventDAO();
            try{
                eventDAO.deleteEvent(selectedEvent);
                events = loadEvents();
                loadEventsOnTable();
            } catch (SQLException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(this, "Não foi possível excluir o usuário selecionado");
            }
        }
    }
    
    private void loadParticipants(){
        
    }
    private List<User> loadUsers(){
        UserDAO userDAO = new UserDAO();
        List<User> users = new ArrayList();
        try{
            users = userDAO.readUsers();
        } catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao carregar os usuários do banco de dados");
        }
        return users;
    }
    public List<Event> loadEvents(){
        EventDAO eventDAO = new EventDAO();
        List<Event> events = new ArrayList();
        try{
            events = eventDAO.readEvents();
        } catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao carregar os eventos do banco de dados");
        }
        return events;
    }
    
    private void loadUsersOnTable(){
        DefaultTableModel model = (DefaultTableModel) userTb.getModel();
        model.setRowCount(0);   
        for(User e : users){ model.addRow(new Object[]{e.getName()}); }
    }
    public void loadEventsOnTable(){
        DefaultTableModel model = (DefaultTableModel) eventTb.getModel();
        model.setRowCount(0);
        for(Event e : events){ model.addRow(new Object[]{e.getName()}); }
    }
    
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Admin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventBt;
    private javax.swing.JButton deleteEventBt;
    private javax.swing.JButton deleteUserBt;
    private javax.swing.JButton editEventBt;
    private javax.swing.JScrollPane eventSp;
    private javax.swing.JTable eventTb;
    private javax.swing.JButton loadParticipantsBt;
    private javax.swing.JScrollPane userSp;
    private javax.swing.JTable userTb;
    // End of variables declaration//GEN-END:variables
}
