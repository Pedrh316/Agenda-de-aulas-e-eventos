package com.mycompany.sistemaagenda.service;

import com.mycompany.sistemaagenda.dao.EventDAO;
import com.mycompany.sistemaagenda.dao.UserEventDAO;
import com.mycompany.sistemaagenda.exceptions.AddEventDialogException;
import com.mycompany.sistemaagenda.exceptions.DeleteEventException;
import com.mycompany.sistemaagenda.exceptions.DeleteUserException;
import com.mycompany.sistemaagenda.exceptions.EditEventException;
import com.mycompany.sistemaagenda.exceptions.EmptyFieldException;
import com.mycompany.sistemaagenda.exceptions.EmptyListException;
import com.mycompany.sistemaagenda.exceptions.InvalidFieldException;
import com.mycompany.sistemaagenda.exceptions.LoadEventsException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.model.User;
import com.mycompany.sistemaagenda.view.Admin;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EventService {
    EventDAO eventDAO = new EventDAO();
    UserEventDAO userEventDAO = new UserEventDAO();
    
    public List<Event> getEvents() throws SQLException, ClassNotFoundException, EmptyListException{
        List<Event> list = eventDAO.readEvents();
        if(list.isEmpty()) throw new EmptyListException("Nenhum evento cadastrado");
        return list;
    }
    
    public void deleteEvent(Event selectedEvent) throws DeleteEventException{
        if(selectedEvent != null){
            try{
                eventDAO.deleteEvent(selectedEvent);
            } catch (SQLException | ClassNotFoundException e){
                throw new DeleteEventException();
            }
        }
    }
    
    public List<Event> loadEvents() throws LoadEventsException{
        List<Event> events = new ArrayList();
        try{
            events = eventDAO.readEvents();
        } catch(SQLException | ClassNotFoundException e){
            throw new LoadEventsException();
        }
        return events;
    }    
    
    public List<User> loadParticipants(Event event) throws ClassNotFoundException, SQLException{
        return userEventDAO.readUsersByEvent(event);
    }
    
    public Event validateEvent(String name, String speaker, String roomText, String feeText, String dateStr) throws InvalidFieldException, EmptyFieldException, EditEventException{
        int room;
        int fee;
        try{
            room = Integer.parseInt(roomText);
            fee = Integer.parseInt(feeText);
        } catch(NumberFormatException e){
            throw new InvalidFieldException("A sala e a inscrição devem ser valores numéricos.");
        }
        
        if(name.isEmpty() || speaker.isEmpty() || roomText.isEmpty() || feeText.isEmpty()){
            throw new EmptyFieldException();
        }        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date;
        try{
            date = LocalDateTime.parse(dateStr, formatter);            
        } catch(DateTimeParseException e){
            throw new InvalidFieldException("O valor do campo data deve se adequar ao formato 'dd/MM/yyyy HH:mm'");
        }        
        return new Event(date, room, name, speaker, fee);   
    }
    
    public void addEvent(String name, String speaker, String roomText, String feeText, String dateStr) throws InvalidFieldException, EmptyFieldException, EditEventException, AddEventDialogException {
        Event event = validateEvent(name, speaker, roomText, feeText, dateStr);
        try{
            eventDAO.createEvent(event);            
        } catch (SQLException | ClassNotFoundException e){
            throw new AddEventDialogException();            
        }
    }
    
    public void updateEvent(Event oldEvent, String name, String speaker, String roomText, String feeText, String dateStr) throws InvalidFieldException, EmptyFieldException, EditEventException {
        Event updtEvent = validateEvent(name, speaker, roomText, feeText, dateStr);
        try{
            eventDAO.updateEvent(oldEvent, updtEvent);                  
        }
        catch(ClassNotFoundException | SQLException e){
            throw new EditEventException();
        }
    }    
    
}
