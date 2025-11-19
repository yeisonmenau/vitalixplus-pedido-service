package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.out.PedidoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class PedidoService implements PedidoRepository {
    private final PedidoRepository pedidoRepository;
    @Override
    public Pedido crearPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido buscarPedidoporId(Long idPedido) {
        return null;
    }

    @Override
    public List<Pedido> mostrarPedido() {
        return List.of();
    }

    @Override
    public Pedido modificarPedido(Pedido pedido) {
        return null;
    }
}
