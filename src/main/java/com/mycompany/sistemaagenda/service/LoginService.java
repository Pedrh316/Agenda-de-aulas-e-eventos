package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.exceptions.UserNotExistsException;
import com.mycompany.sistemaagenda.exceptions.InvalidPasswordException;
import java.sql.SQLException;


public class LoginService {
    
    public User authenticate(String email, String password) 
            throws SQLException, ClassNotFoundException, UserNotExistsException, InvalidPasswordException{
        
        UserDAO userDAO = new UserDAO();
        User user = userDAO.readUser(email);
        
        if(user == null) throw new UserNotExistsException();
        if(!user.getPassword().equals(password)) throw new InvalidPasswordException();
        
        return user;
    }
    
    public void signUp(User user) throws Exception{
        UserDAO userDAO = new UserDAO();
        
        userDAO.createUser(user);
    }
}
