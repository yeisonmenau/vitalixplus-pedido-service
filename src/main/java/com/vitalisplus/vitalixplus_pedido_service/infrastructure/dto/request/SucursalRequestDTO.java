package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class SucursalRequestDTO {
    private String nombre;
    private String direccion;
    private String ciudad;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
}
