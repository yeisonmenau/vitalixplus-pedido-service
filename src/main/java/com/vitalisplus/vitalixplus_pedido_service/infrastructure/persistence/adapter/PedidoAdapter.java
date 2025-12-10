package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.out.PedidoRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.AuxiliarEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.PedidoEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.AuxiliarMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.AuxiliarJpaRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoAdapter implements PedidoRepository {


//    private final AuxiliarMapper auxiliarMapper;
//    private final AuxiliarJpaRepository auxiliarJpaRepository;
//    private final SucursalJpaRepository sucursalJpaRepository;
    @Override
    public Pedido crearPedido(Pedido pedido) {
//        SucursalEntity sucursalEntity = sucursalJpaRepository.findById(auxiliar.getIdSucursal())
//                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + auxiliar.getIdSucursal()));
//        AuxiliarEntity auxiliarEntity = auxiliarMapper.domainToEntity(auxiliar);
//        auxiliarEntity.setEstado(true);
//        AuxiliarEntity auxiliarGuardado = auxiliarJpaRepository.save(auxiliarEntity);
//        return auxiliarMapper.entityToDomain(auxiliarGuardado);

        return null;
    }

    @Override
    public List<Pedido> mostrarpedidos() {
        return List.of();
    }

    @Override
    public Auxiliar buscarPedidoPorId(Long idPedido) {
        return null;
    }

    @Override
    public Auxiliar modificarPedido(Pedido pedido) {
        return null;
    }
}
