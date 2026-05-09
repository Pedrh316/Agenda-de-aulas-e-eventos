package com.mycompany.sistemaagenda.model;


public class User {
    private String email;
    private String name;
    private String password;    
    private boolean admin;

    public User() {
        email = "";
        name = "";
        password = "";        
        admin = false;
    }
    
    public User(String email, String name, String password, boolean admin) {
        this.email = email;
        this.name = name;
        this.password = password;        
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }   

    public boolean isAdmin() {
        return admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }   

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
