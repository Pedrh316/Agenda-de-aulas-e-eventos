package com.mycompany.sistemaagenda.dao;

import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.service.DatabaseService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class UserEventDAO {
    private DatabaseService dbServ;
    
    public UserEventDAO(){
        dbServ = DatabaseService.getInstance();
    }
    
    public void addUserEvent(String email, int room, LocalDateTime dateTime)
            throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO agenda.usuario_evento VALUES (?, ?, ?, ?)";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, email);
            ps.setTimestamp(2, Timestamp.valueOf(dateTime));
            ps.setInt(3, room);
            ps.setBoolean(4, false);
            
            ps.executeUpdate();
        }
    }
    
    public List<Event> readEventsByUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.evento e "
                + "JOIN agenda.usuario_evento ue "
                + "ON e.ev_data_hora = ue.ev_data_hora AND e.ev_sala = ue.ev_sala "
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
    public List<User> readUsersByEvent(Event event) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM agenda.usuario u "
                + "JOIN agenda.usuario_evento ue "
                + "ON u.us_email = ue.us_email "
                + "WHERE ue.ev_data_hora = ? AND ue.ev_sala = ?";
        List<User> list = new LinkedList<>();
        
        try(
            Connection con = dbServ.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);            
        ){
            ps.setString(1, event.getDate().toString() );
            ps.setString(2, String.valueOf(event.getRoom()) );
            
            try(ResultSet rs = ps.executeQuery()){
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
    }
}
