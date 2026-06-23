package com.mycompany.sistemaagenda.navigation;

import com.mycompany.sistemaagenda.controller.AdminController;
import com.mycompany.sistemaagenda.controller.CommonUserController;
import com.mycompany.sistemaagenda.controller.DatabaseController;
import com.mycompany.sistemaagenda.controller.LoginController;
import com.mycompany.sistemaagenda.controller.SignUpController;
import com.mycompany.sistemaagenda.view.*;
import com.mycompany.sistemaagenda.exceptions.WindowNotExistsException;


public class Navigator {    
    private DbConnection dbConWindow;
    private Login loginWindow;
    private SignUp signUpWindow;
    private Admin adminWindow;
    private CommonUser userWindow;
    
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
    
    public void showSignUp(){        
        if(signUpWindow==null){
            signUpWindow = new SignUp();
            signUpWindow.setController(new SignUpController(signUpWindow, this));
        }       
        signUpWindow.setVisible(true);
    }
    
    
    
    public void closeSignUp() throws WindowNotExistsException{
        if(signUpWindow!=null) signUpWindow.setVisible(false);
        else throw new WindowNotExistsException();
    }
    
    public void closeLogin() throws WindowNotExistsException{
        if(loginWindow != null) loginWindow.setVisible(false);
        else throw new WindowNotExistsException();
    }
    
    public void closeDbCon() throws WindowNotExistsException{
        if(dbConWindow != null) dbConWindow.setVisible(false);
        else throw new WindowNotExistsException();
    }
    
    public void adminLogin(){
        if(adminWindow == null) {
            adminWindow = new Admin();
            adminWindow.setController(new AdminController(adminWindow, this));
        }
        adminWindow.setVisible(true);        
    }
    public void adminLogout(){
        if(adminWindow!=null) adminWindow.dispose();
        adminWindow = null;
    }
    
    public void userLogin(){
        if(userWindow == null){
            userWindow = new CommonUser();
            userWindow.setController(new CommonUserController(userWindow, this));
        }
        try{
            closeLogin();
            userWindow.setVisible(true);
        }catch(WindowNotExistsException ex){}        
    }
    
    public void userLogout(){
        if(userWindow != null) userWindow.dispose();
        userWindow = null;
        showLogin();
    }
}
