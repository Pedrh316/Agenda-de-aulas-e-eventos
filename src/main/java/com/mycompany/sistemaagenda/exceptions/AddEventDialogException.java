
package com.mycompany.sistemaagenda.exceptions;


public class AddEventDialogException extends Exception {
    public AddEventDialogException(){
        super("Ocorreu um erro ao adicionar o evento.");
    }
    public AddEventDialogException(String msg){
        super(msg);
    }
}
