package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.service.LoginService;
import com.mycompany.sistemaagenda.view.SignUp;
import com.mycompany.sistemaagenda.exceptions.WindowNotExistsException;


public class SignUpController {
    private final SignUp signUpWindow;
    private final Navigator nav;
    
    public SignUpController(SignUp signUpWindow, Navigator nav){
        this.signUpWindow = signUpWindow;
        this.nav = nav;
    }
    
    public void SignUp(String email, String name, String password, String cpassword){
        if(email.isBlank() || name.isBlank() || password.isBlank()){
            signUpWindow.showErrorMsg("Nenhum campo pode ser vazio", "Erro");
            return;
        }        
        if(!password.equals(cpassword)){
            signUpWindow.showErrorMsg("Senhas diferentes", "Erro");
            return;
        }       
        
        User user = new User(email, name, password, false);
        
        LoginService loginService = new LoginService();
        try {
            loginService.signUp(user);
            signUpWindow.showMsg("Usuário cadastrado com sucesso!");
            signUpWindow.clear();
            nav.closeSignUp();            
        } catch (Exception ex) {
            signUpWindow.showErrorMsg(ex.getMessage(), "Erro");
        }
    }
    
    public void goBack(){
        try{
            nav.closeSignUp();
        } catch(WindowNotExistsException wnee){
            
        }
    }
}
