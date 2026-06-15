package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.navigation.Session;
import com.mycompany.sistemaagenda.view.CommonUser;


public class CommonUserController {
    private final CommonUser userWindow;
    private final Navigator nav;
    
    public CommonUserController(CommonUser userWindow, Navigator nav){
        this.userWindow = userWindow;
        this.nav = nav;
    }
    
    public void sair(){
        nav.showLogin();
        nav.userLogout();
        Session.userLogout();
    }
}
