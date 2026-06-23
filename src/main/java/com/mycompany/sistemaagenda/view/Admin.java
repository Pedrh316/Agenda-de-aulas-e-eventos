package com.mycompany.sistemaagenda.view;

import com.mycompany.sistemaagenda.controller.AdminController;
import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.exceptions.AddEventDialogException;
import com.mycompany.sistemaagenda.exceptions.DeleteEventException;
import com.mycompany.sistemaagenda.exceptions.DeleteUserException;
import com.mycompany.sistemaagenda.exceptions.LoadEventsException;
import com.mycompany.sistemaagenda.exceptions.LoadUsersException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.service.UserService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin extends javax.swing.JFrame {    
    private List<User> users;
    private List<Event> events;
    private Event selectedEvent;
    private User selectedUser;
    private AdminController adminController;
    private UserService userService = new UserService();
    private EventService eventService = new EventService();
    
    public Admin() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setController(AdminController ctrl){
        this.adminController = ctrl;
    }    
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

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
                    .addComponent(deleteEventBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(deleteEventBt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addEventBt, deleteEventBt, deleteUserBt, editEventBt, loadParticipantsBt});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventBtActionPerformed
        adminController.addEvent(this);
    }//GEN-LAST:event_addEventBtActionPerformed

    private void deleteUserBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtActionPerformed
        adminController.deleteUser(this, selectedUser);
    }//GEN-LAST:event_deleteUserBtActionPerformed

    private void loadParticipantsBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadParticipantsBtActionPerformed
        loadParticipants();
    }//GEN-LAST:event_loadParticipantsBtActionPerformed

    private void editEventBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEventBtActionPerformed
         adminController.editEvent(this, selectedEvent);
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
        adminController.deleteEvent(this, selectedEvent);
    }//GEN-LAST:event_deleteEventBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminController.logout();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadParticipants(){
        EventService evento = new EventService();
        try{
            users = evento.loadParticipants(selectedEvent);
            loadUsersOnTable();
        } catch (ClassNotFoundException | SQLException e){
            showLoadUsersError();
        }
        
    }
    public void loadUsersOnTable(){
        DefaultTableModel model = (DefaultTableModel) userTb.getModel();
        model.setRowCount(0);   
        for(User e : users){ model.addRow(new Object[]{e.getName()}); }
    }
    public void loadEventsOnTable(){
        DefaultTableModel model = (DefaultTableModel) eventTb.getModel();
        model.setRowCount(0);
        for(Event e : events){ model.addRow(new Object[]{e.getName()}); }
    }
    
    public void showDeleteEventError(){        
        JOptionPane.showMessageDialog(this, new DeleteEventException().getMessage());
    }
    public void showLoadEventsError(){
        JOptionPane.showMessageDialog(this, new LoadEventsException().getMessage());
    }
    public void showLoadUsersError(){
        JOptionPane.showMessageDialog(this, new LoadUsersException().getMessage());
    }
    public void showDeleteUserError(){
        JOptionPane.showMessageDialog(this, new DeleteUserException().getMessage());
    }
    public void showAddEventError(){
        JOptionPane.showMessageDialog(this, new AddEventDialogException().getMessage());
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton loadParticipantsBt;
    private javax.swing.JScrollPane userSp;
    private javax.swing.JTable userTb;
    // End of variables declaration//GEN-END:variables
}
