/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;

/**
 *
 * @author arthur
 */
public class WindowNotExistsException extends Exception {

    /**
     * Creates a new instance of <code>WindowNotExistsException</code> without
     * detail message.
     */
    public WindowNotExistsException() {
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
