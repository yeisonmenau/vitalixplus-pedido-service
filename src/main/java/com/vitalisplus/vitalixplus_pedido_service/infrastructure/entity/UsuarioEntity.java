package com.vitalisplus.vitalixplus_pedido_service.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    @Column (name = "fecha_registro")
    private LocalDate fechaRegistro;
    private Boolean estado;
}
