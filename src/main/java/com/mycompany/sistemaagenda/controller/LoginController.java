package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.service.LoginService;
import com.mycompany.sistemaagenda.view.Login;


public class LoginController {
    private final Login loginWindow;
    private final Navigator nav;
    private final DatabaseController dbCtrl;
    
    public LoginController(Login loginWindow, Navigator nav, DatabaseController dbCtrl){
        this.loginWindow = loginWindow;
        this.nav = nav;
        this.dbCtrl = dbCtrl;
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
            if(user == null){
                loginWindow.loginError();
            }else{
                loginWindow.loginSuccess();
                dbCtrl.setActiveUser(user);
                nav.closeLogin();
                if(user.isAdmin()){
                    nav.adminLogin();
                }else{
                    nav.userLogin();
                }
            }
        } catch (Exception ex) {
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
