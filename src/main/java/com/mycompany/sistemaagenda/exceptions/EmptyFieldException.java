/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;

public class EmptyFieldException extends Exception{
    public EmptyFieldException(){
        super("Nenhum dos campos podem ser vazios.");
    }
    public EmptyFieldException(String msg){
        super(msg);
    }
}
