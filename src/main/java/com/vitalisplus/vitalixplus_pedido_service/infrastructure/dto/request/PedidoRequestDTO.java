package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoRequestDTO {
    private Long idUsuario;
    private String nombreSucursal;
    private Long idAuxiliar;
    private Long idDomiciliario;
    private LocalDate fechaPedido;
    private String direccionEntrega;
    private Double costoEnvio;
    private Double costoPedido;
    private List<Integer> listaDePedidos;
    private Double totalPagar;
}
