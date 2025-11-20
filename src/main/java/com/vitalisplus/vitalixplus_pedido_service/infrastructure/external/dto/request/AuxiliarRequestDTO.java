package com.vitalisplus.vitalixplus_pedido_service.infrastructure.external.dto.request;

import lombok.Data;

@Data
public class AuxiliarRequestDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private String nombreSucursal;
}
