/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagenda.exceptions;

/**
 *
 * @author Aluno
 */
public class LoadUsersException extends Exception{
    public LoadUsersException(){
        super("Ocorreu um erro ao carregar os usuários do banco de dados");
    }
    public LoadUsersException(String msg){
        super(msg);
    }
}
