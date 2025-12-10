package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.out.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PedidoService{
    private final PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.crearPedido(pedido);
    }

    public List<Pedido> mostrarPedidos() {
        return pedidoRepository.mostrarpedidos();
    }

    public Pedido buscarPedidoporId(Long idPedido) {
        return pedidoRepository.buscarPedidoPorId(idPedido);
    }

    public Pedido modificarPedido(Long idPedido, Pedido pedido) {
        return pedidoRepository.modificarPedido(idPedido, pedido);
    }


}
