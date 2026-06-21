package com.mycompany.sistemaagenda.controller;

import com.google.zxing.WriterException;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.exceptions.InsertionFailedException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.service.PixService;
import com.mycompany.sistemaagenda.service.UserService;
import com.mycompany.sistemaagenda.view.CommonUser;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    public void tableItemSelected(int room, LocalDate date, LocalTime time, float fee){
        String pix = "";
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        UserService us = new UserService();
        BufferedImage qrcode;
        
        if(!userWindow.showQuenstionMsg("Deseja se inscrever no evento?", "Inscrição")) return;
        
        try{
            us.subscribeToEvent(Session.getLoggedUser(), room, dateTime);
            
            if(fee > 0){
                pix = PixService.generatePixPayload("equiperocketpagamentos@gmail.com", fee);
                qrcode = PixService.generateQRCode(pix, 500, 500);
                
                userWindow.showPayMsg(qrcode);
            }
        } catch(InsertionFailedException ex){
            userWindow.showErrorMsg(ex.getMessage(), "Falha na inscrição");
        } catch(ClassNotFoundException | SQLException ex){
            userWindow.showErrorMsg(ex.getMessage(), "Erro de conexão");
        } catch(WriterException we){
            userWindow.showErrorMsg(we.getMessage(), "Erro ao gerar QR Code");
        }
    }
}
