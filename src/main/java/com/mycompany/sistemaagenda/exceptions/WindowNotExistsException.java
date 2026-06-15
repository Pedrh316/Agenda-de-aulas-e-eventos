package com.mycompany.sistemaagenda.exceptions;


public class WindowNotExistsException extends Exception {

    /**
     * Creates a new instance of <code>WindowNotExistsException</code> without
     * detail message.
     */
    public WindowNotExistsException() {
        super("Janela não existe");
    }

    /**
     * Constructs an instance of <code>WindowNotExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public WindowNotExistsException(String msg) {
        super(msg);
    }
}
