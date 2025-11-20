package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalResponseDTO {
    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String ciudad;
    private LocalDateTime horarioApertura;
    private LocalDateTime horarioCierre;
    private Boolean estado;
}
