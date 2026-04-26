package com.mycompany.sistemaagenda.controller;
import com.mycompany.sistemaagenda.service.LoginService;

public class LoginController {
    
    public boolean login(String email, String senha) throws Exception{
        if (email.isBlank() || senha.isBlank()) {
            throw new Exception("Preencha todos os campos");
        }

        LoginService loginService = new LoginService();

        return loginService.authenticate(email, senha);    
    }
}
