package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.service.DatabaseService;
import com.mycompany.sistemaagenda.view.DbConnection;


public class DatabaseController {
    private final DbConnection dbConWindow;
    private final Navigator nav;
    private final DatabaseService dbServ;
    private User activeUser;
    
    public DatabaseController(DbConnection dbConWindow, Navigator nav) {        
        this.dbConWindow = dbConWindow;
        this.nav = nav;
        dbServ = DatabaseService.getInstance();
    }
    
    public void connect() {
        try {            
            dbServ.connect();
            dbServ.generate();
            nav.showLogin();            
        } catch (Exception e) {            
            nav.showDbCon();
        }
    }
    
    public void connect(String url, String user, String password){
        try{
            dbServ.connect(url, user, password);
            dbServ.generate();
            dbConWindow.showSuccessMsg();
            nav.showLogin();            
        } catch(Exception e){
            dbConWindow.showErrorMsg(e);
        }
    }
    
    public void setActiveUser(User activeUser){
        this.activeUser = activeUser;
    }
    
    public User getActvieUser(){
        return this.activeUser;
    }
}
