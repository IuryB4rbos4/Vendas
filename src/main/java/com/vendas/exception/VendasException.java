package com.vendas.exception;

public class VendasException extends RuntimeException {
    public VendasException() {
        super("Erro inesperado no AppVendas!");
    }

    public VendasException(String message) {
        super(message);
    }
}