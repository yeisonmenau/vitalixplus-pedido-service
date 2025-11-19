package com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    private LocalDate fecha_registro;
    private Boolean estado;
}
