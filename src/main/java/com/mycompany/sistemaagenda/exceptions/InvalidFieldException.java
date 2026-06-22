
package com.mycompany.sistemaagenda.exceptions;

public class InvalidFieldException extends Exception {
    public InvalidFieldException(){
        super("Algum campo está inválido");
    }
    public InvalidFieldException(String msg){
        super(msg);
    }
    
}
