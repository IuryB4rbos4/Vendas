package com.vendas.exception;

public class ProdutoNaoExisteException extends VendasException {
    public ProdutoNaoExisteException(){
        super("O produto consultado não existe!");
    }

    public ProdutoNaoExisteException(String message){
        super(message);
    }
}
