package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request;

import lombok.Data;

@Data
public class AuxiliarRequestDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private Long idSucursal;
}
