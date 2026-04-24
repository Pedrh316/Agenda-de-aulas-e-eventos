package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.service.DatabaseService;
import java.sql.SQLException;


public class DatabaseController {

    public DatabaseController() {
    }
    
    public void connect(String url, String user, String password) throws ClassNotFoundException, SQLException {
        DatabaseService.getInstance().connect(url, user, password);
    }
}
