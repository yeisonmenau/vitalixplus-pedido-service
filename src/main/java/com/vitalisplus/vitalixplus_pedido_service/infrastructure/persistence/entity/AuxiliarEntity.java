package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auxiliar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuxiliarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auxiliar")
    private Long idAuxiliar;
    private String nombre;
    private String apellido;
    private String telefono;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private SucursalEntity sucursal;
}
