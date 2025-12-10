package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
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

    @Override
    public List<Sucursal> mostrarSucursales() {
        List<SucursalEntity> sucursalesRegistradas = sucursalJpaRepository.findAll();
        return sucursalesRegistradas
                .stream()
                .map(sucursalMapper::entityToDomain)
                .toList();
    }

    @Override
    public Sucursal buscarSucursalporId(Long idSucursal) {
        SucursalEntity existente = sucursalJpaRepository.findById(idSucursal)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + idSucursal));
        return sucursalMapper.entityToDomain(existente);
    }

    @Override
    public Sucursal modificarSucursal(Long idSucursal, Sucursal sucursal) {
        SucursalEntity existente = sucursalJpaRepository.findById(idSucursal)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + idSucursal));
        SucursalEntity sucursalActualizada = sucursalMapper.domainToEntity(sucursal);
        sucursalActualizada.setIdSucursal(existente.getIdSucursal());
        SucursalEntity guardado = sucursalJpaRepository.save(sucursalActualizada);
        return sucursalMapper.entityToDomain(guardado);
    }

    @Override
    public String cambiarEstadoSucursal(Long idSucursal) {
        Sucursal sucursal = buscarSucursalporId(idSucursal);
        sucursal.setEstado(!sucursal.getEstado());
        modificarSucursal(idSucursal, sucursal);
        return "Se cambió el estado de la sucursal con id: " + idSucursal;
    }

}
