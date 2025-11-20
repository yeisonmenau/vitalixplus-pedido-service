package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.SucursalRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.SucursalResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import org.springframework.stereotype.Component;

@Component
public class SucursalMapper {

    public SucursalEntity domainToEntity(Sucursal sucursal) {
        return new SucursalEntity(
                null,
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getCiudad(),
                sucursal.getHorarioApertura(),
                sucursal.getHorarioCierre(),
                sucursal.getEstado()
        );
    }

    public Sucursal entityToDomain(SucursalEntity sucursalEntity) {
        return new Sucursal(
                sucursalEntity.getIdSucursal(),
                sucursalEntity.getNombre(),
                sucursalEntity.getDireccion(),
                sucursalEntity.getCiudad(),
                sucursalEntity.getHorarioApertura(),
                sucursalEntity.getHorarioCierre(),
                sucursalEntity.getEstado()
        );
    }

    public Sucursal requestToDomain(SucursalRequestDTO sucursalRequestDTO){
        return new Sucursal(
                null,
                sucursalRequestDTO.getNombre(),
                sucursalRequestDTO.getDireccion(),
                sucursalRequestDTO.getCiudad(),
                sucursalRequestDTO.getHorarioApertura(),
                sucursalRequestDTO.getHorarioCierre(),
                true
        );
    }

    public SucursalResponseDTO domainToResponse(Sucursal sucursal){
        return new SucursalResponseDTO(
                sucursal.getIdSucursal(),
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getCiudad(),
                sucursal.getHorarioApertura(),
                sucursal.getHorarioCierre(),
                sucursal.getEstado()
        );
    }

}
