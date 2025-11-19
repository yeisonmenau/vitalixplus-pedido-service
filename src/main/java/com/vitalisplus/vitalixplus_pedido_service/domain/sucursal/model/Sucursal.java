package com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String ciudad;
    private LocalDateTime horario_apertura;
    private LocalDateTime horario_cierre;
    private Boolean estado;
}
