package com.vitalisplus.vitalixplus_pedido_service.application.exception;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(String message) {
        super(message);
    }
}
