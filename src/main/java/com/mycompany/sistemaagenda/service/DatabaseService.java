package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.model.Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


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
    
    public Database connect() throws Exception {
        Properties props = new Properties();
                
        props.load(new FileInputStream("config/database.properties"));

        connect(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
        return db;
    }
    
    public void connect(String url, String user, String password) throws ClassNotFoundException, SQLException {
        this.db = new Database(url, password, user);
        Class.forName(db.getDriver());
        Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());        
        con.close();
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(db.getDriver());
        return DriverManager.getConnection(
            db.getUrl(),
            db.getUser(),
            db.getPassword()
        );
    }
    
    public void generate() throws ClassNotFoundException, SQLException, FileNotFoundException{
        if(db==null) return;
        
        try(
            Connection con = getConnection();
            Statement st = con.createStatement();
            Scanner scanner = new Scanner(new File("src/main/java/com/mycompany/sistemaagenda/service/Agenda.sql"))
        ){

            con.setAutoCommit(false);

            try{
                StringBuilder sb = new StringBuilder();

                while(scanner.hasNextLine()){
                    sb.append(scanner.nextLine()).append("\n");
                }

                String[] sts = sb.toString().split(";");
                for(String exe : sts){
                    if(!exe.trim().equals("")){
                        st.executeUpdate(exe);
                    }
                }
                con.commit();
                
            }catch(SQLException e){
                con.rollback();
                throw e;
            }
        }
    }
}
