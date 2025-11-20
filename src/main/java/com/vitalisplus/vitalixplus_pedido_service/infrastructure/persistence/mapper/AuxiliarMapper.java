package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.AuxiliarRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.AuxiliarResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.AuxiliarEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.AuxiliarJpaRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuxiliarMapper {
    private final AuxiliarJpaRepository auxiliarJpaRepository;
    private final SucursalJpaRepository sucursalJpaRepository;


    public AuxiliarEntity domainToEntity (Auxiliar auxiliar){
        return new AuxiliarEntity(
                null,
                auxiliar.getNombre(),
                auxiliar.getApellido(),
                auxiliar.getTelefono(),
                auxiliar.getEstado(),
                new SucursalEntity(
                        auxiliar.getSucursal().getIdSucursal(),
                        auxiliar.getSucursal().getNombre(),
                        auxiliar.getSucursal().getDireccion(),
                        auxiliar.getSucursal().getCiudad(),
                        auxiliar.getSucursal().getHorarioApertura(),
                        auxiliar.getSucursal().getHorarioCierre(),
                        auxiliar.getSucursal().getEstado())
        );
    }

    public Auxiliar entityToDomain (AuxiliarEntity auxiliarEntity){
        return new Auxiliar(
                auxiliarEntity.getIdAuxiliar(),
                auxiliarEntity.getNombre(),
                auxiliarEntity.getApellido(),
                auxiliarEntity.getTelefono(),
                auxiliarEntity.getEstado(),
                new Sucursal(
                        auxiliarEntity.getSucursal().getIdSucursal(),
                        auxiliarEntity.getSucursal().getNombre(),
                        auxiliarEntity.getSucursal().getDireccion(),
                        auxiliarEntity.getSucursal().getCiudad(),
                        auxiliarEntity.getSucursal().getHorarioApertura(),
                        auxiliarEntity.getSucursal().getHorarioCierre(),
                        auxiliarEntity.getSucursal().getEstado()));
    }

    public AuxiliarEntity auxiliarRequestToEntity(AuxiliarRequestDTO auxiliarRequestDTO) {
        SucursalEntity sucursalEntity = sucursalJpaRepository.findByNombre(auxiliarRequestDTO.getNombreSucursal());

        return new AuxiliarEntity(
                null,
                auxiliarRequestDTO.getNombre(),
                auxiliarRequestDTO.getApellido(),
                auxiliarRequestDTO.getTelefono(),
                true,
                sucursalEntity
        );
    }

    public AuxiliarResponseDTO entityToAuxiliarResponse (AuxiliarEntity auxiliarEntity) {
        return new AuxiliarResponseDTO(
                auxiliarEntity.getIdAuxiliar(),
                auxiliarEntity.getNombre(),
                auxiliarEntity.getApellido(),
                auxiliarEntity.getTelefono(),
                auxiliarEntity.getSucursal().getNombre(),
                auxiliarEntity.getEstado());
    }

    public Auxiliar requestToDomain(AuxiliarRequestDTO auxiliarRequestDTO){
        return new Auxiliar(
                null,
                auxiliarRequestDTO.getNombre(),
                auxiliarRequestDTO.getApellido(),
                auxiliarRequestDTO.getTelefono(),
                true,
                new Sucursal(
                        null,
                        auxiliarRequestDTO.getNombreSucursal(),
                        null,
                        null,
                        null,
                        null,
                        null)
        );
    }

    public AuxiliarResponseDTO domainToResponse(Auxiliar auxiliar){
        AuxiliarEntity auxiliarEntity = domainToEntity(auxiliar);
        return entityToAuxiliarResponse(auxiliarEntity);
    }


}
