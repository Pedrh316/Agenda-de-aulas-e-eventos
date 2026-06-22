
package com.mycompany.sistemaagenda.exceptions;


public class DeleteEventException extends Exception {
    public DeleteEventException(){
        super("Não foi possível excluir o evento selecionado");
    }
    public DeleteEventException(String msg){
        super(msg);
    }
}
