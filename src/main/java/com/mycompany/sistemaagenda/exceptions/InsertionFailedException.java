package com.mycompany.sistemaagenda.exceptions;


public class InsertionFailedException extends Exception {
    
    public InsertionFailedException() {
        super("Falha na inserção");
    }
    
    public InsertionFailedException(String msg) {
        super(msg);
    }
}
