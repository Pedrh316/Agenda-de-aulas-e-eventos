package com.mycompany.sistemaagenda.model;


public class User {
    private String email;
    private String password;
    private String name;
    private boolean admin;

    public User() {
        email = "";
        password = "";
        name = "";
        admin = false;
    }
    
    public User(String email, String password, String name, boolean admin) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
