package com.vitalisplus.vitalixplus_pedido_service.infrastructure.external.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SucursalRequestDTO {
    private String nombre;
    private String direccion;
    private String ciudad;
    private LocalDateTime horarioApertura;
    private LocalDateTime horarioCierre;
}
