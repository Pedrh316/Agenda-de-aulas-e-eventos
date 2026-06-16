package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import java.sql.SQLException;
import java.util.List;


public class UserService {
    
    public List<Event> getUserEvents(User user) throws SQLException, ClassNotFoundException, EmptyListException{
        UserDAO udao = new UserDAO();
        
        List<Event> list = udao.readUserEvents(user);
        
        if(list.isEmpty()) throw new EmptyListException("Usuário sem eventos");
        
        return list;
    }
    
}
