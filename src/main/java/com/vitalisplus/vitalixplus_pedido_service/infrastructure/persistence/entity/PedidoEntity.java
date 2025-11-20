package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_pedido")
    private Long idPedido;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private SucursalEntity sucursal;
    @ManyToOne
    @JoinColumn(name = "id_auxiliar", nullable = false)
    private AuxiliarEntity auxiliar;
    @ManyToOne
    @JoinColumn(name = "id_domiciliario", nullable = false)
    private DomiciliarioEntity domiciliario;
    @Column (name = "fecha_pedido")
    private LocalDate fechaPedido;
    @Column (name = "direccion_entrega")
    private String direccionEntrega;
    @Column (name = "costo_envio")
    private Double costoEnvio;
    @Column (name = "costo_pedido")
    private Double costoPedido;
    @Column (name = "lista_de_pedidos")
    private List<Integer> listaDePedidos;
    @Column (name = "total_pagar")
    private Double totalPagar;
}
