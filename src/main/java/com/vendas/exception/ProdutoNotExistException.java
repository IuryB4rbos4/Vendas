package com.vendas.exception;

public class ProdutoNotExistException extends VendasException {
    public ProdutoNotExistException(){
        super("O produto consultado não existe!");
    }

    public ProdutoNotExistException(String message){
        super(message);
    }
}
