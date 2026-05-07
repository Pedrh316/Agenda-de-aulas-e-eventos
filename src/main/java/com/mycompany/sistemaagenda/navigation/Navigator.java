package com.mycompany.sistemaagenda.navigation;

import com.mycompany.sistemaagenda.controller.DatabaseController;
import com.mycompany.sistemaagenda.controller.LoginController;
import com.mycompany.sistemaagenda.view.*;


public class Navigator {    
    private DbConnection dbConWindow;
    private Login loginWindow;
    private Admin adminWindow;
    
    public Navigator(){}
    
    public void showDbCon(){
        if(loginWindow!=null) loginWindow.setVisible(false);        
        if(dbConWindow==null){
            dbConWindow = new DbConnection();
            dbConWindow.setController(new DatabaseController(dbConWindow, this));
        }
        dbConWindow.setVisible(true);
    }
    
    public void showLogin(){        
        if(loginWindow==null){
            loginWindow = new Login();
            loginWindow.setController(new LoginController(loginWindow, this));
        }
        if(dbConWindow!=null) dbConWindow.setVisible(false);
        loginWindow.setVisible(true);
    }
    
    public void adminLogin(){
        if(adminWindow == null) adminWindow = new Admin();
        adminWindow.setVisible(true);        
    }
    public void adminLogout(){
        if(adminWindow!=null) adminWindow.dispose();
        adminWindow = null;
    }
        
}
