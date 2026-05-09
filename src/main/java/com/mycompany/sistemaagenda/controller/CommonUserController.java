/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.navigation.Navigator;
import com.mycompany.sistemaagenda.view.CommonUser;

/**
 *
 * @author arthur
 */
public class CommonUserController {
    private final Navigator nav;
    private final CommonUser userWindow;
    private final DatabaseController dbCtrl;
    
    public CommonUserController(Navigator nav, CommonUser userWindow, DatabaseController dbCtrl){
        this.nav = nav;
        this.userWindow = userWindow;
        this.dbCtrl = dbCtrl;
    }
    
    public void sair(){
        nav.showLogin();
        nav.userLogout();
        dbCtrl.setActiveUser(null);       
    }
    
    public DatabaseController getDatabaseController(){
        return dbCtrl;
    }
}
