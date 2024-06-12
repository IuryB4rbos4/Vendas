package com.vendas.exception;

public class ItensVazioException extends VendasException {
    public ItensVazioException(){
        super("Lista de compras vazia!");
    }

    public ItensVazioException(String message){
        super(message);
    }
}
