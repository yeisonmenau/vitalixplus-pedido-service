package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response;

import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.EstadoPedido;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {
    private Long idPedido;
    private Long idUsuario;
    private String nombreSucursal;
    private Long idAuxiliar;
    private Long idDomiciliario;
    private LocalDate fechaPedido;
    private String direccionEntrega;
    private Double costoEnvio;
    private Double costoPedido;
    private List<Long> listaDeProductos;
    private Double totalPagar;
    private EstadoPedido estado;
}
