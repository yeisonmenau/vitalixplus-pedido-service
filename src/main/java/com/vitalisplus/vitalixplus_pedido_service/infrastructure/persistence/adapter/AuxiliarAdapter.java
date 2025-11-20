package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.AuxiliarNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.AuxiliarEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.AuxiliarMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.AuxiliarJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuxiliarAdapter implements AuxiliarRepository {
    private final AuxiliarMapper auxiliarMapper;
    private final AuxiliarJpaRepository auxiliarJpaRepository;

    @Override
    public Auxiliar crearAuxiliar(Auxiliar auxiliar) {
        AuxiliarEntity auxiliarEntity = auxiliarMapper.domainToEntity(auxiliar);
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
    public Auxiliar modificarAuxiliar(Auxiliar auxiliar) {
        AuxiliarEntity existente = auxiliarJpaRepository.findById(auxiliar.getIdAuxiliar())
                .orElseThrow(() -> new AuxiliarNotFoundException("Auxiliar no encontrado con id: " + auxiliar.getIdAuxiliar()));
        AuxiliarEntity auxiliarActualizado = auxiliarMapper.domainToEntity(auxiliar);
        auxiliarActualizado.setIdAuxiliar(existente.getIdAuxiliar());
        AuxiliarEntity guardado = auxiliarJpaRepository.save(auxiliarActualizado);
        return auxiliarMapper.entityToDomain(guardado);
    }

    @Override
    public String cambiarEstadoAuxiliar(Auxiliar auxiliar) {
        Auxiliar auxiliarEntidad = buscarAuxiliarporId(auxiliar.getIdAuxiliar());
        auxiliarEntidad.setEstado(!auxiliarEntidad.getEstado());
        modificarAuxiliar(auxiliarEntidad);
        return "Se cambió el estado del auxiliar con id: " + auxiliar.getIdAuxiliar();
    }
}
