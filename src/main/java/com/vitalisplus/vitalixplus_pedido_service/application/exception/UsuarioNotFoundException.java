package com.vitalisplus.vitalixplus_pedido_service.application.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
