package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.application.exception.UsuarioNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.EstadoPedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.PedidoRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.PedidoResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.PedidoEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.*;
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
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final SucursalJpaRepository sucursalJpaRepository;
    private final AuxiliarJpaRepository auxiliarJpaRepository;
    private final DomiciliarioJpaRepository domiciliarioJpaRepository;

    public PedidoEntity domainToEntity(Pedido pedidoDomain) {
        PedidoEntity entity = new PedidoEntity();
        entity.setIdPedido(pedidoDomain.getIdPedido());
        entity.setFechaPedido(pedidoDomain.getFechaPedido());
        entity.setDireccionEntrega(pedidoDomain.getDireccionEntrega());
        entity.setCostoEnvio(pedidoDomain.getCostoEnvio());
        entity.setCostoPedido(pedidoDomain.getCostoPedido());
        entity.setListaDeProductos(pedidoDomain.getListaDeProductos());
        entity.setTotalPagar(pedidoDomain.getTotalPagar());
        entity.setEstado(pedidoDomain.getEstado());
        return entity;
    }

    public Pedido entityToDomain (PedidoEntity pedidoEntity){
        return new Pedido(
                pedidoEntity.getIdPedido(),
                usuarioMapper.entityToDomain(pedidoEntity.getUsuario()),
                sucursalMapper.entityToDomain(pedidoEntity.getSucursal()),
                auxiliarMapper.entityToDomain(pedidoEntity.getAuxiliar()),
                domiciliarioMapper.entityToDomain(pedidoEntity.getDomiciliario()),
                pedidoEntity.getFechaPedido(),
                pedidoEntity.getDireccionEntrega(),
                pedidoEntity.getCostoEnvio(),
                pedidoEntity.getCostoPedido(),
                pedidoEntity.getListaDeProductos(),
                pedidoEntity.getTotalPagar(),
                pedidoEntity.getEstado()
        );
    }

    public Pedido requestToDomain (PedidoRequestDTO pedidoRequest){
        return new Pedido(
                null,
                usuarioMapper.entityToDomain(usuarioJpaRepository.findById(pedidoRequest.getIdUsuario())
                        .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + pedidoRequest.getIdUsuario()))),
                sucursalMapper.entityToDomain(sucursalJpaRepository.findByNombre(pedidoRequest.getNombreSucursal())),
                auxiliarMapper.entityToDomain(auxiliarJpaRepository.findById(pedidoRequest.getIdAuxiliar())
                        .orElseThrow(() -> new SucursalNotFoundException("Auxiliar no encontrado con id: " + pedidoRequest.getIdAuxiliar()))),
                domiciliarioMapper.entityToDomain(domiciliarioJpaRepository.findById(pedidoRequest.getIdDomiciliario())
                        .orElseThrow(() -> new SucursalNotFoundException("Domiciliario no encontrado con id: " + pedidoRequest.getIdDomiciliario()))),
                pedidoRequest.getFechaPedido(),
                pedidoRequest.getDireccionEntrega(),
                pedidoRequest.getCostoEnvio(),
                pedidoRequest.getCostoPedido(),
                pedidoRequest.getListaDeProductos(),
                pedidoRequest.getTotalPagar(),
                EstadoPedido.PENDIENTE
        );
    }

    public PedidoResponseDTO domainToResponse (Pedido pedidoDomain){
        return new PedidoResponseDTO(
                pedidoDomain.getIdPedido(),
                pedidoDomain.getUsuario().getIdUsuario(),
                pedidoDomain.getSucursal().getNombre(),
                pedidoDomain.getAuxiliar().getIdAuxiliar(),
                pedidoDomain.getDomiciliario().getIdDomiciliario(),
                pedidoDomain.getFechaPedido(),
                pedidoDomain.getDireccionEntrega(),
                pedidoDomain.getCostoEnvio(),
                pedidoDomain.getCostoPedido(),
                pedidoDomain.getListaDeProductos(),
                pedidoDomain.getTotalPagar(),
                pedidoDomain.getEstado()
        );
    }

}
