package com.mycompany.sistemaagenda.model;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime date;
    private int room;
    private String name;
    private String speaker;
    private int fee;
    
    public Event(){
        date = null;
        room = 0;
        name = "";
        speaker = "";
        fee = 0;
    }
    
    public Event(LocalDateTime date, int room, String name, String speaker, int fee) {
        this.date = date;
        this.room = room;
        this.name = name;
        this.speaker = speaker;
        this.fee = fee;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public int getFee() {
        return fee;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
