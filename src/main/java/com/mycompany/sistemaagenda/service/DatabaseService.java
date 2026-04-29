package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.model.Database;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class DatabaseService {
    private static DatabaseService instance;
    private Database db;
    
    private DatabaseService() {
        db = null;        
    }
    
    public static DatabaseService getInstance() {
        if(instance == null) instance = new DatabaseService();
        return instance;
    }
    
    public void connect() throws Exception {
        Properties props = new Properties();
                
        props.load(new FileInputStream("config/database.properties"));

        connect(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
    }
    
    public void connect(String url, String user, String password) throws ClassNotFoundException, SQLException {
        this.db = new Database(url, password, user);
        testConnection();
    }
    
    private void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName(db.getDriver());
        Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());        
        con.close();
    }
        
}
