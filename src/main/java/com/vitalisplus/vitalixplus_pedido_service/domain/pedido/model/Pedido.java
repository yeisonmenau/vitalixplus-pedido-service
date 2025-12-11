package com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Long idPedido;
    private Usuario usuario;
    private Sucursal sucursal;
    private Auxiliar auxiliar;
    private Domiciliario domiciliario;
    private LocalDate fechaPedido;
    private String direccionEntrega;
    private Double costoEnvio;
    private Double costoPedido;
    private List<Long> listaDeProductos;
    private Double totalPagar;
}
