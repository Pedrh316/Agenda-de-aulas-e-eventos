/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;

/**
 *
 * @author Aluno
 */
public class EditEventException extends Exception {
    public EditEventException(){
        super("Ocorreu um erro ao editar os valores");
    }
    public EditEventException(String msg){
        super(msg);
    }
    
}
