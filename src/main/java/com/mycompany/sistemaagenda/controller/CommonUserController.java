package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.service.UserService;
import com.mycompany.sistemaagenda.view.CommonUser;
import java.sql.SQLException;
import java.util.List;


public class CommonUserController {
    private final CommonUser userWindow;
    private final Navigator nav;
    
    public CommonUserController(CommonUser userWindow, Navigator nav){
        this.userWindow = userWindow;
        this.nav = nav;
        
        if(userWindow!=null) userWindow.setWelcomeLbText("Olá, "+Session.getLoggedUser().getName()+"!");
    }
    
    public void logout(){        
        nav.userLogout();
        Session.userLogout();                
    }
    
    public void avalEventsBt(){
        userWindow.setTab(1);
    }
    
    public void userEventsBt(){
        userWindow.setTab(2);
    }
    
    public void tabSelected(int tabIndex){
        switch (tabIndex) {
            case 0 -> {}
            
            case 1 -> {
                EventService es = new EventService();
                try{
                    List<Event> events = es.getEvents();
                    
                    userWindow.updateTable(userWindow.getAvailableEventsTable(), events);
                    
                } catch(EmptyListException ex){
                    userWindow.showInfoMsg("Não há eventos disponíveis no momento.", "Que pena!");
                } catch(ClassNotFoundException | SQLException ex){
                    userWindow.showErrorMsg(ex.getMessage(), "Erro ao atualizar tabela");
                }
            }
            
            case 2 -> {
                UserService us = new UserService();
                try{
                    List<Event> events = us.getUserEvents(Session.getLoggedUser());
                    
                    userWindow.updateTable(userWindow.getUserEventsTable(), events);
                } catch(EmptyListException ex){
                    userWindow.showInfoMsg("Você ainda não se inscreveu em nenhum evento.", "Tabela");
                } catch(ClassNotFoundException | SQLException ex){
                    userWindow.showErrorMsg(ex.getMessage(), "Erro ao atualizar tabela");
                }
            }
            
            default -> {}
        }
    }
}
