package com.mycompany.sistemaagenda.controller;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.service.LoginService;
import com.mycompany.sistemaagenda.view.Login;

public class LoginController {
    private final Login loginWindow;
    private final Navigator nav;
    
    public LoginController(Login loginWindow){
        this.loginWindow = loginWindow;
        nav = Navigator.getInstance();
    }
    
    public void login(String email, String senha) throws Exception{
        if (email.isBlank() || senha.isBlank()) {
            throw new Exception("Preencha todos os campos");
        }

        LoginService loginService = new LoginService();
        
        User user = loginService.authenticate(email, senha);
        
        if(user == null){
            loginWindow.loginError();
        } else{
            loginWindow.loginSuccess();
            if(user.isAdmin()){
                nav.adminLogin();
            }else{
                //nav.userLogin();
            }
        }
    }
    
    public void dbCon(){
        nav.showDbCon();
    }
}
