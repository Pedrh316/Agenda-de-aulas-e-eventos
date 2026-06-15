package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.exceptions.InvalidPasswordException;
import com.mycompany.sistemaagenda.exceptions.UserNotExistsException;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.service.LoginService;
import com.mycompany.sistemaagenda.view.Login;
import java.sql.SQLException;


public class LoginController {
    private final Login loginWindow;
    private final Navigator nav;    
    
    public LoginController(Login loginWindow, Navigator nav){
        this.loginWindow = loginWindow;
        this.nav = nav;        
    }
    
    public void login(String email, String password){
        if(email.isBlank() || password.isBlank()){
            loginWindow.showErrorMsg("Preencha todos os campos", "Erro");
            return;
        }

        LoginService loginService = new LoginService();
        
        User user;
        try {
            user = loginService.authenticate(email, password);
            
            loginWindow.loginSuccess();            
            Session.setLoggedUser(user);
                        
            if(user.isAdmin()){
                nav.adminLogin();
            }else{
                nav.userLogin();
            }
            
        } catch (InvalidPasswordException | UserNotExistsException ex){
            loginWindow.loginError();
        } catch (ClassNotFoundException | SQLException ex) {
            loginWindow.showErrorMsg(ex.getMessage(), "Erro de conexão");
        }
    }
    
    public void dbCon(){
        nav.showDbCon();
    }
    
    public void signUp(){
        nav.showSignUp();
    }
}
