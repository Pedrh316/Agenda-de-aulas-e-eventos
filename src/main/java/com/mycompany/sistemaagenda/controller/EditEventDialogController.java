/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.controller;

import com.mycompany.sistemaagenda.exceptions.EditEventException;
import com.mycompany.sistemaagenda.exceptions.EmptyFieldException;
import com.mycompany.sistemaagenda.exceptions.InvalidFieldException;
import com.mycompany.sistemaagenda.exceptions.LoadEventsException;
import com.mycompany.sistemaagenda.model.Event;
import com.mycompany.sistemaagenda.service.EventService;
import com.mycompany.sistemaagenda.view.Admin;
import com.mycompany.sistemaagenda.view.EditEventDialog;
import java.time.LocalDateTime;

public class EditEventDialogController {
    EventService eventService = new EventService();
    public void saveEdit(Admin admin, EditEventDialog editEventDialog, Event oldEvent, String name, String speaker, String roomText, String feeText, String date){
        try{
            eventService.updateEvent(oldEvent, name, speaker, roomText, feeText, date);
            admin.setEvents(eventService.loadEvents());
            admin.loadEventsOnTable();
            editEventDialog.dispose();
        } catch(EditEventException | EmptyFieldException | InvalidFieldException | LoadEventsException e){
            editEventDialog.showEditEventError(e);
        }
    }
}
