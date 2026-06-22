package com.mycompany.sistemaagenda.controller;
import com.mycompany.sistemaagenda.exceptions.AddEventDialogException;
import com.mycompany.sistemaagenda.exceptions.EditEventException;
import com.mycompany.sistemaagenda.exceptions.EmptyFieldException;
import com.mycompany.sistemaagenda.exceptions.InvalidFieldException;
import com.mycompany.sistemaagenda.exceptions.LoadEventsException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.view.AddEventDialog;
import com.mycompany.sistemaagenda.view.Admin;


public class AddEventDialogController {
    EventService eventService = new EventService();
       
    public void addEvent(Admin admin, AddEventDialog addEventDialog, String name, String speaker, String roomText, String feeText, String dateStr){
        try{
            eventService.addEvent(name, speaker, roomText, feeText, dateStr);
            admin.setEvents(eventService.loadEvents());
            admin.loadEventsOnTable();     
            addEventDialog.dispose();
        } catch (AddEventDialogException e){
            admin.showAddEventError();
        } catch (LoadEventsException e){
            admin.showLoadEventsError();
        } catch (EditEventException | EmptyFieldException | InvalidFieldException e){
            addEventDialog.showAddEventError(e);
        }
    }
}
