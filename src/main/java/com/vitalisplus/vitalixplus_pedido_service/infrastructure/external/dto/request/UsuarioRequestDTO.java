package com.vitalisplus.vitalixplus_pedido_service.infrastructure.external.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    private LocalDate fechaRegistro;
}
