/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;

public class LoadEventsException extends Exception {
    public LoadEventsException() {
        super("Ocorreu um erro ao carregar os eventos do banco de dados");
    }
    public LoadEventsException(String msg) {
        super(msg);
    }
}
