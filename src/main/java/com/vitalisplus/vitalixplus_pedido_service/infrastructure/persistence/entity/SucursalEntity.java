package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_sucursal")
    private Long idSucursal;
    private String nombre;
    private String direccion;
    private String ciudad;
    @Column (name = "horario_apertura")
    private LocalTime horarioApertura;
    @Column (name = "horario_cierre")
    private LocalTime horarioCierre;
    private Boolean estado;

}
