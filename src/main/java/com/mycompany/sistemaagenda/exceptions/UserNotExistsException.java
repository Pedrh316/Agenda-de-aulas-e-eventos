package com.mycompany.sistemaagenda.exceptions;


public class UserNotExistsException extends Exception {

    /**
     * Creates a new instance of <code>UserNotExistsException</code> without
     * detail message.
     */
    public UserNotExistsException() {
        super("Usuário inexistente");
    }

    /**
     * Constructs an instance of <code>UserNotExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserNotExistsException(String msg) {
        super(msg);
    }    
}
