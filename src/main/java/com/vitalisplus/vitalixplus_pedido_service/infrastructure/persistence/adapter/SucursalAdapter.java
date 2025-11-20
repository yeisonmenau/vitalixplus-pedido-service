package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.SucursalMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class SucursalAdapter implements SucursalRepository {
    private final SucursalMapper sucursalMapper;
    private final SucursalJpaRepository sucursalJpaRepository;
    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
        SucursalEntity sucursalEntity = sucursalMapper.domainToEntity(sucursal);
        sucursalEntity.setEstado(true);
        SucursalEntity sucursalGuardada = sucursalJpaRepository.save(sucursalEntity);
        return sucursalMapper.entityToDomain(sucursalGuardada);
    }

}
