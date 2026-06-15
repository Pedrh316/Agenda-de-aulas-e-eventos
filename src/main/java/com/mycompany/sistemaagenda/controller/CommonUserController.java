package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.view.CommonUser;
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
                EventDAO edao = new EventDAO();
                try {
                    List<Event> events = edao.readEvents();
                    
                    userWindow.updateTable(userWindow.getAvailableEventsTable(), events);
                    
                } catch (Exception ex) {
                    // mostrar erro ao atualizar tabela
                }
            }
            
            case 2 -> {
                // criar metodo para ler eventos do usuario no dao
                //userWindow.updateTable(userWindow.getUserEventsTable(), events);
            }
            
            default -> {}
        }
    }
}
