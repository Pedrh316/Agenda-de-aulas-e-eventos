package com.mycompany.sistemaagenda.model;


public class Database {
    private final String driver;
    private String url;
    private String senha;
    private String user;

    public Database() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        url = "";
        senha = "";
        user = "";
    }
    
    public Database(String url, String senha, String user) {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = url;
        this.senha = senha;
        this.user = user;
    }
    
    public String getDriver() {
        return driver;
    }
    
    public String getUrl() {
        return url;
    }

    public String getSenha() {
        return senha;
    }

    public String getUser() {
        return user;
    }    

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
