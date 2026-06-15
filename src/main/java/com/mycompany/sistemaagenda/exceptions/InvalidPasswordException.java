package com.mycompany.sistemaagenda.exceptions;


public class InvalidPasswordException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPasswordException</code> without
     * detail message.
     */
    public InvalidPasswordException() {
        super("Senha incorreta"); // Nao mostrar esta mensagem a qualquer usuario no login
    }

    /**
     * Constructs an instance of <code>InvalidPasswordException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
