package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.UserDAO;
import com.mycompany.sistemaagenda.model.User;
import exceptions.UserNotExistsException;


public class LoginService {
    
    public User authenticate(String email, String password) throws Exception{        
        UserDAO userDAO = new UserDAO();
        User user = userDAO.readUser(email);
        
        if(user == null) throw new UserNotExistsException();
        
        if(user.getPassword().equals(password)) return user;
        else return null;
    }
    
    public void signUp(User user) throws Exception{
        UserDAO userDAO = new UserDAO();
        
        userDAO.createUser(user);
    }
}
