package com.mycompany.sistemaagenda.dao;

import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.service.DatabaseService;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class EventDAO {
    private DatabaseService dbServ;
    
    public EventDAO(){
        dbServ = DatabaseService.getInstance();
    }
    
    public void createEvent(Event event) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO agenda.evento VALUES (?, ?, ?, ?, ?)";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setTimestamp(1, Timestamp.valueOf(event.getDate()));
            ps.setInt(2, event.getRoom());
            ps.setString(3, event.getName());
            ps.setString(4, event.getSpeaker());
            ps.setInt(5, event.getFee());
            
            ps.executeUpdate();
        }
    }
    
    public Event readEvent(LocalDateTime date, int room) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.evento WHERE ev_data_hora = ? AND ev_sala = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setTimestamp(1, Timestamp.valueOf(date));
            ps.setInt(2, room);
            
            try(ResultSet rs = ps.executeQuery()){            
                if(rs.next()){
                    return new Event(
                            rs.getTimestamp("ev_data_hora").toLocalDateTime(),
                            rs.getInt("ev_sala"),
                            rs.getString("ev_nome"),
                            rs.getString("ev_palestrante"),
                            rs.getInt("ev_inscricao")
                    );
                }
                return null;
            }
        }
    }
    
    public List<Event> readEvents() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM agenda.evento";
        List<Event> list = new LinkedList<>();
        
        try(
            Connection con = dbServ.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
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
    
    public int updateEvent(Event event, Event updtEvent) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE agenda.evento SET ev_data_hora = ?,"
                + "ev_sala = ?,"
                + "ev_nome = ?,"
                + "ev_palestrante = ?,"
                + "ev_inscricao = ?"
                + " WHERE ev_data_hora = ? AND ev_sala = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                       
            ps.setTimestamp(1, Timestamp.valueOf(updtEvent.getDate()));
            ps.setInt(2, updtEvent.getRoom());
            ps.setString(3, updtEvent.getName());
            ps.setString(4, updtEvent.getSpeaker());
            ps.setInt(5, updtEvent.getFee());
            
            ps.setTimestamp(6, Timestamp.valueOf(event.getDate()));
            ps.setInt(7, event.getRoom());
            
            return ps.executeUpdate();
        }
    }
    
    public int deleteEvent(Event event) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM agenda.evento WHERE ev_data_hora = ? AND ev_sala = ?";
        
        try(Connection con = dbServ.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                                    
            ps.setTimestamp(1, Timestamp.valueOf(event.getDate()));
            ps.setInt(2, event.getRoom());
            
            return ps.executeUpdate();
        }
    }
}
