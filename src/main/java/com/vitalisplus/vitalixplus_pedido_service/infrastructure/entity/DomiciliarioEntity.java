package com.vitalisplus.vitalixplus_pedido_service.infrastructure.entity;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "domiciliario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomiciliarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domiciliario")
    private Long idDomiciliario;
    private String nombre;
    private String apellido;
    private String telefono;
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;
}
