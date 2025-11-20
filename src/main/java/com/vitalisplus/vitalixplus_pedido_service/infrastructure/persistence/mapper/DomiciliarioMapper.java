package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.DomiciliarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.DomiciliarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.DomiciliarioEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.DomiciliarioJpaRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DomiciliarioMapper {
    private final SucursalJpaRepository sucursalJpaRepository;

    public DomiciliarioEntity domainToEntity(Domiciliario domiciliario) {
        SucursalEntity sucursal = sucursalJpaRepository.findById(domiciliario.getIdSucursal())
                .orElseThrow(() ->
                        new SucursalNotFoundException("Sucursal no encontrada con id: " + domiciliario.getIdSucursal()));

        return new DomiciliarioEntity(
                null,
                domiciliario.getNombre(),
                domiciliario.getApellido(),
                domiciliario.getTelefono(),
                domiciliario.getPlacaVehiculo(),
                domiciliario.getEstado(),
                sucursal
        );
    }

    public Domiciliario entityToDomain (DomiciliarioEntity domiciliarioEntity){
        return new Domiciliario(
                domiciliarioEntity.getIdDomiciliario(),
                domiciliarioEntity.getNombre(),
                domiciliarioEntity.getApellido(),
                domiciliarioEntity.getTelefono(),
                domiciliarioEntity.getPlacaVehiculo(),
                domiciliarioEntity.getEstado(),
                domiciliarioEntity.getSucursal().getIdSucursal()
        );
    }

    public Domiciliario requestToDomain(DomiciliarioRequestDTO domiciliarioRequestDTO){
        return new Domiciliario(
                null,
                domiciliarioRequestDTO.getNombre(),
                domiciliarioRequestDTO.getApellido(),
                domiciliarioRequestDTO.getTelefono(),
                domiciliarioRequestDTO.getPlacaVehiculo(),
                true,
                domiciliarioRequestDTO.getIdSucursal()
        );
    }

    public DomiciliarioResponseDTO entityToResponse (Domiciliario domiciliario) {
        SucursalEntity sucursalEntity = sucursalJpaRepository.findById(domiciliario.getIdSucursal())
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + domiciliario.getIdSucursal()));
        return new DomiciliarioResponseDTO(
                domiciliario.getIdDomiciliario(),
                domiciliario.getNombre(),
                domiciliario.getApellido(),
                domiciliario.getTelefono(),
                domiciliario.getPlacaVehiculo(),
                sucursalEntity.getNombre(),
                domiciliario.getEstado()
        );
    }
}
