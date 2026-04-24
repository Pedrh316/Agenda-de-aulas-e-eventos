package com.mycompany.sistemaagenda.model;


public class Database {
    private final String driver;
    private String url;
    private String password;
    private String user;

    public Database() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        url = "";
        password = "";
        user = "";
    }
    
    public Database(String url, String password, String user) {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = url;
        this.password = password;
        this.user = user;
    }
    
    public String getDriver() {
        return driver;
    }
    
    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }    

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
