package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;


import com.vitalisplus.vitalixplus_pedido_service.application.exception.SucursalNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.AuxiliarRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.AuxiliarResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.AuxiliarEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.SucursalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuxiliarMapper {
    private final SucursalJpaRepository sucursalJpaRepository;

    public AuxiliarEntity domainToEntity (Auxiliar auxiliar){

        return new AuxiliarEntity(
                auxiliar.getIdAuxiliar(),
                auxiliar.getNombre(),
                auxiliar.getApellido(),
                auxiliar.getTelefono(),
                auxiliar.getEstado(),
                new SucursalEntity(
                        auxiliar.getIdSucursal(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null)
        );
    }

    public Auxiliar entityToDomain (AuxiliarEntity auxiliarEntity){
        return new Auxiliar(
                auxiliarEntity.getIdAuxiliar(),
                auxiliarEntity.getNombre(),
                auxiliarEntity.getApellido(),
                auxiliarEntity.getTelefono(),
                auxiliarEntity.getEstado(),
                auxiliarEntity.getSucursal().getIdSucursal()
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
                auxiliarRequestDTO.getIdSucursal()
        );
    }

    public AuxiliarResponseDTO domainToResponse(Auxiliar auxiliar){
        SucursalEntity sucursalEntity = sucursalJpaRepository.findById(auxiliar.getIdSucursal())
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrada con id: " + auxiliar.getIdSucursal()));
        return new AuxiliarResponseDTO(
                auxiliar.getIdAuxiliar(),
                auxiliar.getNombre(),
                auxiliar.getApellido(),
                auxiliar.getTelefono(),
                sucursalEntity.getNombre(),
                auxiliar.getEstado()
        );
    }


}
