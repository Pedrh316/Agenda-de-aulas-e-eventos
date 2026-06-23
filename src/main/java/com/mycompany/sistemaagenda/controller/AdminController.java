package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.exceptions.DeleteEventException;
import com.mycompany.sistemaagenda.exceptions.DeleteUserException;
import com.mycompany.sistemaagenda.exceptions.LoadEventsException;
import com.mycompany.sistemaagenda.exceptions.LoadUsersException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.service.UserService;
import com.mycompany.sistemaagenda.view.AddEventDialog;
import com.mycompany.sistemaagenda.view.Admin;
import com.mycompany.sistemaagenda.view.CommonUser;
import com.mycompany.sistemaagenda.view.EditEventDialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AdminController {
    private final EventService eventService = new EventService();
    private final UserService userService = new UserService();
    private final Navigator nav;
    private Admin adminWindow;
    
    public AdminController(Admin adminWindow, Navigator nav){
        this.adminWindow = adminWindow;
        this.nav = nav;        
        try{
            adminWindow.setUsers(userService.loadUsers());
            adminWindow.setEvents(eventService.loadEvents());
            adminWindow.loadUsersOnTable();
            adminWindow.loadEventsOnTable();
        } catch(LoadUsersException e){
            adminWindow.showLoadUsersError();
        } catch(LoadEventsException e){
            adminWindow.showLoadEventsError();
        }
    }
    
    public void addEvent(Admin admin){
        AddEventDialog view = new AddEventDialog(admin);
        view.setVisible(true);
    }
    
    public void deleteEvent(Admin admin, Event selectedEvent){
        try{
            eventService.deleteEvent(selectedEvent);
            admin.setEvents(eventService.loadEvents());
            admin.loadEventsOnTable();
        } catch (DeleteEventException | LoadEventsException e){
            admin.showDeleteEventError();
            admin.showLoadEventsError();
        }
    }
    
    public void deleteUser(Admin admin, User selectedUser){
        try{
            userService.deleteUser(selectedUser);
            admin.setUsers(userService.loadUsers());
            admin.loadUsersOnTable();
        } catch (DeleteUserException e){
            admin.showDeleteUserError();
        } catch (LoadUsersException e){
            admin.showLoadUsersError();
        }        
    }
    
    public void editEvent(Admin admin, Event selectedEvent){
        EditEventDialog editEventDialog = new EditEventDialog(admin, selectedEvent);
        editEventDialog.setVisible(true);
    }
     
    public void logout(){
        nav.adminLogout();
    }
    
}
