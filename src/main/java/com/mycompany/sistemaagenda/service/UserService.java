package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.UserEventDAO;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.exceptions.InsertionFailedException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public class UserService {
    
    public List<Event> getUserEvents(User user) throws SQLException, ClassNotFoundException, EmptyListException{
        UserEventDAO uedao = new UserEventDAO();
        
        List<Event> list = uedao.readEventsByUser(user);
        
        if(list.isEmpty()) throw new EmptyListException("Usuário sem eventos");
        
        return list;
    }
    
    public void subscribeToEvent(User user, int room, LocalDateTime dateTime) 
            throws SQLException, ClassNotFoundException, InsertionFailedException{
        
        UserEventDAO uedao = new UserEventDAO();
        
        try{
            uedao.addUserEvent(user.getEmail(), room, dateTime);
        } catch(SQLException ex){
            if(ex.getErrorCode() == 1062) throw new InsertionFailedException("Já inscrito no evento");
            if(ex.getErrorCode() == 1452) throw new InsertionFailedException("O evento não existe");
            
            throw ex;
        }                
    }
    
    public void setFeeAs(boolean paid, String email, int room, LocalDateTime dateTime) 
            throws SQLException, ClassNotFoundException
    {
        UserEventDAO uedao = new UserEventDAO();
        
        uedao.updateUserEventFee(paid, email, room, dateTime);
    }
    
    public boolean isFeePaid(String email, int room, LocalDateTime dateTime) 
            throws SQLException, ClassNotFoundException, EmptyListException
    {
        UserEventDAO uedao = new UserEventDAO();
        
        int result = uedao.isFeePaid(email, room, dateTime);
        
        if(result == 1) return true;
        else if (result == 0) return false;
        else throw new EmptyListException("Não foi possível encontrar a inscrição do usuário nesse evento");
    }
}
