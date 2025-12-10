package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.PedidoEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.PedidoJpaRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
    private final PedidoJpaRepository pedidoJpaRepository;
    private final UsuarioMapper usuarioMapper;
    private final SucursalMapper sucursalMapper;
    private final AuxiliarMapper auxiliarMapper;
    private final DomiciliarioMapper domiciliarioMapper;

    public PedidoEntity domainToEntity (Pedido pedidoDomain){
        return new PedidoEntity(
                pedidoDomain.getIdPedido(),
                usuarioMapper.domainToEntity(pedidoDomain.getUsuario()),
                sucursalMapper.domainToEntity(pedidoDomain.getSucursal()),
                auxiliarMapper.domainToEntity(pedidoDomain.getAuxiliar()),
                domiciliarioMapper.domainToEntity(pedidoDomain.getDomiciliario()),
                pedidoDomain.getFechaPedido(),
                pedidoDomain.getDireccionEntrega(),
                pedidoDomain.getCostoEnvio(),
                pedidoDomain.getCostoPedido(),
                pedidoDomain.getListaDeProductos(),
                pedidoDomain.getTotalPagar()
        );
    }
}
