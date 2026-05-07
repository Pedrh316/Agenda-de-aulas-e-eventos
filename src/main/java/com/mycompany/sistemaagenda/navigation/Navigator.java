package com.mycompany.sistemaagenda.navigation;

import com.mycompany.sistemaagenda.view.*;


public class Navigator {
    private static Navigator navigator;
    
    private DbConnection dbConWindow;
    private Login loginWindow;
    private Admin adminWindow;
    
    private Navigator(){}
    
    public static Navigator getInstance(){
        if(navigator==null) navigator = new Navigator();
        return navigator;           
    }
    
    
    public void showDbCon(){
        if(loginWindow!=null) loginWindow.setVisible(false);
        if(dbConWindow==null) dbConWindow = new DbConnection();
        dbConWindow.setVisible(true);
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
