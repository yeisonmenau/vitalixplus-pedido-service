package com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auxiliar {
    private Long idAuxiliar;
    private String nombre;
    private String apellido;
    private String telefono;
    private Boolean estado;
    private Long idSucursal;
}
