package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomiciliarioResponseDTO {
    private Long idDomiciliario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String placaVehiculo;
    private String nombreSucursal;
    private Boolean estado;
}
