package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.AuxiliarNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.AuxiliarEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.AuxiliarMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.AuxiliarJpaRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuxiliarAdapter implements AuxiliarRepository {
    private final AuxiliarMapper auxiliarMapper;
    private final AuxiliarJpaRepository auxiliarJpaRepository;
    private final SucursalJpaRepository sucursalJpaRepository;

    @Override
    public Auxiliar crearAuxiliar(Auxiliar auxiliar) {
        SucursalEntity sucursalEntity = sucursalJpaRepository.findById(auxiliar.getIdSucursal())
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + auxiliar.getIdSucursal()));
        AuxiliarEntity auxiliarEntity = auxiliarMapper.domainToEntity(auxiliar);
        auxiliarEntity.setEstado(true);
        AuxiliarEntity auxiliarGuardado = auxiliarJpaRepository.save(auxiliarEntity);
        return auxiliarMapper.entityToDomain(auxiliarGuardado);
    }

    @Override
    public List<Auxiliar> mostrarAuxiliares() {
        List<AuxiliarEntity> auxiliaresRegistrados = auxiliarJpaRepository.findAll();
        return auxiliaresRegistrados.stream()
                .map(auxiliarMapper::entityToDomain)
                .toList();
    }

    @Override
    public Auxiliar buscarAuxiliarporId(Long idAuxiliar) {
        AuxiliarEntity existente = auxiliarJpaRepository.findById(idAuxiliar)
                .orElseThrow(() -> new AuxiliarNotFoundException("Auxiliar no encontrado con id: " + idAuxiliar));
        return auxiliarMapper.entityToDomain(existente);
    }

    @Override
    public Auxiliar modificarAuxiliar(Long idAuxiliar, Auxiliar auxiliar) {
        AuxiliarEntity existente = auxiliarJpaRepository.findById(idAuxiliar)
                .orElseThrow(() -> new AuxiliarNotFoundException("Auxiliar no encontrado con id: " + idAuxiliar));
        AuxiliarEntity auxiliarActualizado = auxiliarMapper.domainToEntity(auxiliar);
        auxiliarActualizado.setIdAuxiliar(existente.getIdAuxiliar());
        AuxiliarEntity guardado = auxiliarJpaRepository.save(auxiliarActualizado);
        return auxiliarMapper.entityToDomain(guardado);
    }

    @Override
    public String cambiarEstadoAuxiliar(Long idAuxiliar) {
        Auxiliar auxiliarEntidad = buscarAuxiliarporId(idAuxiliar);
        auxiliarEntidad.setEstado(!auxiliarEntidad.getEstado());
        modificarAuxiliar(idAuxiliar, auxiliarEntidad);
        return "Se cambió el estado del auxiliar con id: " + idAuxiliar;
    }
}
