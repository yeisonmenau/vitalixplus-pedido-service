package com.vitalisplus.vitalixplus_pedido_service.domain.pedido.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;

import java.util.List;

public interface PedidoRepository {
    Pedido crearPedido (Pedido pedido);
    Pedido buscarPedidoporId (Long idPedido);
    List<Pedido> mostrarPedido ();
    Pedido modificarPedido (Pedido pedido);
}
