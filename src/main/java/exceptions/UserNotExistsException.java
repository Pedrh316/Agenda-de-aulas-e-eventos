/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author arthur
 */
public class UserNotExistsException extends Exception {

    /**
     * Creates a new instance of <code>UserNotExistsException</code> without
     * detail message.
     */
    public UserNotExistsException() {
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
    
    public String getMessage(){
        return "Usuário inexistente";
    }
}
