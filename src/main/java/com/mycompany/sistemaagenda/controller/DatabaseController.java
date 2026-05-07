package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.service.DatabaseService;
import com.mycompany.sistemaagenda.view.DbConnection;


public class DatabaseController {
    private final DbConnection dbConWindow;
    private final Navigator nav;
    
    public DatabaseController(DbConnection dbConWindow, Navigator nav) {        
        this.dbConWindow = dbConWindow;        
        this.nav = nav;        
    }
    
    public void connect() {
        try {            
            DatabaseService.getInstance().connect();
            nav.showLogin();
        } catch (Exception e) {            
            nav.showDbCon();
        }
    }
    
    public void connect(String url, String user, String password){
        try{
            DatabaseService.getInstance().connect(url, user, password);
            dbConWindow.showSuccessMsg();
            nav.showLogin();            
        } catch(Exception e){
            dbConWindow.showErrorMsg(e);
        }
    }
}
