package com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domiciliario {
    private Long idDomiciliario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String placaVehiculo;
    private Boolean estado;
    private Long idSucursal;
}
