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
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(db.getDriver());
        return DriverManager.getConnection(
            db.getUrl(),
            db.getUser(),
            db.getPassword()
        );
    }
    
    private void generate() throws SQLException, ClassNotFoundException{
        try{
            connect();
        } catch(Exception e){
            System.out.println("Exceção:" + e);
            return;
        } 
        
        Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
        Statement st = con.createStatement();
        File script = new File("./Agenda.mwb");
        String linha = new String();
        StringBuilder texto_string = new StringBuilder();
        
        try(Scanner leitor = new Scanner(script)){
            while(leitor.hasNextLine()){
                linha = leitor.nextLine();
                texto_string.append(linha);
            }
            
            String[] sts = texto_string.toString().split(";");
            
            for(String executavel : sts){
                if(!executavel.trim().equals("")) st.executeUpdate(executavel);
            }
        } catch(FileNotFoundException fnfe){
            System.out.println("Arquivo inexistente ou corrompido");
        } finally{
            st.close();
            con.close();
        }
    }
}
