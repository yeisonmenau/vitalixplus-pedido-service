package com.vitalisplus.vitalixplus_pedido_service.infrastructure.external.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuxiliarResponseDTO {
    private Long idAuxiliar;
    private String nombre;
    private String apellido;
    private String telefono;
    private String nombreSucursal;
    private Boolean estado;
}
