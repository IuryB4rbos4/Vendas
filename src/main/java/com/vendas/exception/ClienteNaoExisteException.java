package com.vendas.exception;

public class ClienteNaoExisteException extends VendasException {
    public ClienteNaoExisteException(){
        super("O cliente consultado não existe!");
    }

    public ClienteNaoExisteException(String message){
        super(message);
    }
}
