package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.dao.UserEventDAO;
import com.mycompany.sistemaagenda.exceptions.DeleteUserException;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.exceptions.InsertionFailedException;
import com.mycompany.sistemaagenda.exceptions.LoadUsersException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.view.Admin;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


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
    
    public List<User> loadUsers() throws LoadUsersException{
        UserDAO userDAO = new UserDAO();
        List<User> users = new ArrayList();
        try{
            users = userDAO.readUsers();
        } catch(SQLException | ClassNotFoundException e){
            throw new LoadUsersException();
        }
        return users;
    }
    
    public void deleteUser(User selectedUser) throws DeleteUserException{
        UserDAO userDAO = new UserDAO();
        try{
            userDAO.deleteUser(selectedUser);
        } catch (SQLException | ClassNotFoundException e){
            throw new DeleteUserException();
        }
    }
    
}
