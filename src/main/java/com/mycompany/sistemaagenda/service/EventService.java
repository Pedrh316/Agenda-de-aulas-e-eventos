package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.model.Event;
import java.sql.SQLException;
import java.util.List;


public class EventService {
    public List<Event> getEvents() throws SQLException, ClassNotFoundException, EmptyListException{
        EventDAO edao = new EventDAO();
        
        List<Event> list = edao.readEvents();
        
        if(list.isEmpty()) throw new EmptyListException("Nenhum evento cadastrado");
        
        return list;
    }
}
