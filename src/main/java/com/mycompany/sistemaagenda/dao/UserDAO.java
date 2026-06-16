package com.mycompany.sistemaagenda.dao;

import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.service.DatabaseService;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDAO {
    private DatabaseService dbServ;
    
    public UserDAO(){
        dbServ = DatabaseService.getInstance();
    }
    
    public void createUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO agenda.usuario VALUES (?, ?, ?, ?)";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, user.getEmail());            
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setBoolean(4, user.isAdmin());
            
            ps.executeUpdate();
        }
    }
    
    public User readUser(String email) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.usuario WHERE us_email = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, email);
            
            try(ResultSet rs = ps.executeQuery()){            
                if(rs.next()){
                    return new User(
                            rs.getString("us_email"),
                            rs.getString("us_nome"),
                            rs.getString("us_senha"),
                            rs.getBoolean("us_admin")
                    );
                }
                return null;
            }
        }
    }
    
    public List<User> readUsers() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.usuario";
        List<User> list = new LinkedList<>();
        
        try(
            Connection con = dbServ.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                list.add(new User(                        
                        rs.getString("us_email"),
                        rs.getString("us_nome"),
                        rs.getString("us_senha"),
                        rs.getBoolean("us_admin")
                ));
            }            
            return list;
        }
    }
    
    public List<Event> readUserEvents(User user) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.evento e "
                + "JOIN agenda.usuario_evento ue "
                + "ON e.ev_data_hora = ue.ev_data_hora AND e.ev_sala = ue.ev_sala"
                + "WHERE ue.us_email = ?";
        List<Event> list = new LinkedList<>();
        
        try(
            Connection con = dbServ.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);            
        ){
            ps.setString(1, user.getEmail());
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    list.add(new Event(
                            rs.getTimestamp("ev_data_hora").toLocalDateTime(),
                            rs.getInt("ev_sala"),
                            rs.getString("ev_nome"),
                            rs.getString("ev_palestrante"),
                            rs.getInt("ev_inscricao")
                    ));
                }
                return list;
            }
        }
    }
    
    public int updateUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE agenda.usuario SET us_nome = ?,"
                + "us_senha = ?,"
                + "us_admin = ?"
                + " WHERE us_email = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                        
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isAdmin());
            ps.setString(4, user.getEmail());
            
            return ps.executeUpdate();
        }
    }
    
    public int deleteUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM agenda.usuario WHERE us_email = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                                    
            ps.setString(1, user.getEmail());
            
            return ps.executeUpdate();
        }
    }
}
