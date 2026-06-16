package com.mycompany.sistemaagenda.exceptions;


public class EmptyListException extends Exception {

    /**
     * Creates a new instance of <code>EmptyListException</code> without detail
     * message.
     */
    public EmptyListException() {
        super("Lista vazia");
    }

    /**
     * Constructs an instance of <code>EmptyListException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyListException(String msg) {
        super(msg);
    }
}
