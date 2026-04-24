package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.service.DatabaseService;
import java.sql.SQLException;


public class DatabaseController {

    public DatabaseController() {
    }
    
    public boolean connect() {
        try {
            DatabaseService.getInstance().connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void connect(String url, String user, String password) throws ClassNotFoundException, SQLException {
        DatabaseService.getInstance().connect(url, user, password);
    }
}
