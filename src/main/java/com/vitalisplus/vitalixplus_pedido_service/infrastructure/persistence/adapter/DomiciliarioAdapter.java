package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.DomiciliarioNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.out.DomiciliarioRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.DomiciliarioEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.DomiciliarioMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.DomiciliarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DomiciliarioAdapter implements DomiciliarioRepository {
    private final DomiciliarioJpaRepository domiciliarioJpaRepository;
    private final DomiciliarioMapper domiciliarioMapper;

    @Override
    public Domiciliario crearDomiciliario(Domiciliario domiciliario) {
        DomiciliarioEntity domiciliarioEntity = domiciliarioMapper.domainToEntity(domiciliario);
        domiciliarioEntity.setEstado(true);
        DomiciliarioEntity domiciliarioGuardado = domiciliarioJpaRepository.save(domiciliarioEntity);
        return domiciliarioMapper.entityToDomain(domiciliarioGuardado);
    }

    @Override
    public List<Domiciliario> mostrarDomiciliarios() {
        List<DomiciliarioEntity> domiciliariosRegistrados = domiciliarioJpaRepository.findAll();
        return domiciliariosRegistrados.stream()
                .map(domiciliarioMapper::entityToDomain)
                .toList();
    }

    @Override
    public Domiciliario buscarDomiciliarioporId(Long idDomiciliario) {
        DomiciliarioEntity existente = domiciliarioJpaRepository.findById(idDomiciliario)
                .orElseThrow(() -> new DomiciliarioNotFoundException("Domiciliario no encontrado con id: " + idDomiciliario));
        return domiciliarioMapper.entityToDomain(existente);

    }

    @Override
    public Domiciliario modificarDomiciliario(Long idDomiciliario,Domiciliario domiciliario) {
        DomiciliarioEntity existente = domiciliarioJpaRepository.findById(idDomiciliario)
                .orElseThrow(() -> new DomiciliarioNotFoundException("Domiciliario no encontrado con id: " + idDomiciliario));
        DomiciliarioEntity domiciliarioActualizado = domiciliarioMapper.domainToEntity(domiciliario);
        domiciliarioActualizado.setIdDomiciliario(existente.getIdDomiciliario());
        DomiciliarioEntity guardado = domiciliarioJpaRepository.save(domiciliarioActualizado);
        return domiciliarioMapper.entityToDomain(guardado);
    }

    @Override
    public String cambiarEstadoDomiciliario(Long idDomiciliario) {
        DomiciliarioEntity existente = domiciliarioJpaRepository.findById(idDomiciliario)
                .orElseThrow(() -> new DomiciliarioNotFoundException("Domiciliario no encontrado con id: " + idDomiciliario));

        Domiciliario domiciliarioEntidad  = buscarDomiciliarioporId(idDomiciliario);
        domiciliarioEntidad.setEstado(!domiciliarioEntidad.getEstado());
        modificarDomiciliario(idDomiciliario,domiciliarioEntidad);
        return "Se cambió el estado del domiciliario con id: " + idDomiciliario;
    }
}
