package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.PedidoNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.application.exception.UsuarioNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.out.PedidoRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.*;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.AuxiliarMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.PedidoMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoAdapter implements PedidoRepository {
    private final PedidoMapper pedidoMapper;
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final SucursalJpaRepository sucursalJpaRepository;
    private final AuxiliarJpaRepository auxiliarJpaRepository;
    private final DomiciliarioJpaRepository domiciliarioJpaRepository;
    private final PedidoJpaRepository pedidoJpaRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {
        UsuarioEntity usuarioEntity = usuarioJpaRepository.findById(pedido.getUsuario().getIdUsuario())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + pedido.getUsuario().getIdUsuario()));
        SucursalEntity sucursalEntity = sucursalJpaRepository.findById(pedido.getSucursal().getIdSucursal())
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + pedido.getSucursal().getIdSucursal()));
        AuxiliarEntity auxiliarEntity = auxiliarJpaRepository.findById(pedido.getAuxiliar().getIdAuxiliar())
                .orElseThrow(() -> new SucursalNotFoundException("Auxiliar no encontrado con id: " + pedido.getAuxiliar().getIdAuxiliar()));
        DomiciliarioEntity domiciliarioEntity = domiciliarioJpaRepository.findById(pedido.getDomiciliario().getIdDomiciliario())
                .orElseThrow(() -> new SucursalNotFoundException("Domiciliario no encontrado con id: " + pedido.getDomiciliario().getIdDomiciliario()));
        PedidoEntity pedidoEntity = pedidoMapper.domainToEntity(pedido);
        PedidoEntity pedidoGuardado = pedidoJpaRepository.save(pedidoEntity);
        return pedidoMapper.entityToDomain(pedidoGuardado);
    }

    @Override
    public List<Pedido> mostrarpedidos() {
        List<PedidoEntity> pedidosRegistrados = pedidoJpaRepository.findAll();
        return pedidosRegistrados
                .stream()
                .map(pedidoMapper::entityToDomain)
                .toList();
    }

    @Override
    public Pedido buscarPedidoPorId(Long idPedido) {
        PedidoEntity existente = pedidoJpaRepository.findById(idPedido)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con id: " + idPedido));
        return pedidoMapper.entityToDomain(existente);
    }

    @Override
    public Pedido modificarPedido(Long idPedido, Pedido pedido) {
        PedidoEntity existente = pedidoJpaRepository.findById(idPedido)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con id: " + idPedido));
        PedidoEntity pedidoActualizado = pedidoMapper.domainToEntity(pedido);
        pedidoActualizado.setIdPedido(existente.getIdPedido());
        PedidoEntity guardado = pedidoJpaRepository.save(pedidoActualizado);
        return pedidoMapper.entityToDomain(guardado);
    }
}
