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
import java.io.IOException;
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
                    userWindow.clearTable(userWindow.getAvailableEventsTable());
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
                    userWindow.clearTable(userWindow.getUserEventsTable());
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
        
        if(!userWindow.showQuestionMsg("Deseja se inscrever no evento?", "Inscrição")) return;

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
    
    public void tableItemSelected(int room, LocalDate date, LocalTime time, float fee, String email){
        boolean opt = false;
        UserService us = new UserService();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        
        if(!userWindow.showQuestionMsg("Deseja cancelar inscrição no evento?", 
                "Cancelamento de inscrição")) return;
        
        try{
            us.unsubscribeToEvent(email, room, dateTime);
            
            opt = userWindow.showQuestionMsg("Deseja baixar comprovante de cancelamento?", "Cancelamento");
            
            if(opt == true) PixService.generateCancelTicket(email, date, time, fee);
            
        } catch(ClassNotFoundException | SQLException clnf_sql_e){
            userWindow.showErrorMsg(clnf_sql_e.getMessage(), "Erro de conexão");
        } catch(IOException ioe){
            userWindow.showErrorMsg(ioe.getMessage(), "Erro de arquivo");
        }
    }
}
