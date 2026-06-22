/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;


public class DeleteUserException extends Exception{
    public DeleteUserException(){
        super("Não foi possível excluir o usuário selecionado");
    }
    public DeleteUserException(String msg){
        super(msg);
    }
    
}
