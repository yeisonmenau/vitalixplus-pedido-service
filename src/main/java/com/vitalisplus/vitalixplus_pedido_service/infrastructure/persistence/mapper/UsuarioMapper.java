package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper;

import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.UsuarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.UsuarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntity domainToEntity(Usuario usuario) {
        return new UsuarioEntity(
                null,
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getPassword(),
                usuario.getDireccion(),
                usuario.getFechaRegistro(),
                usuario.getEstado()
        );
    }

    public Usuario entityToDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getNombre(),
                usuarioEntity.getApellido(),
                usuarioEntity.getEmail(),
                usuarioEntity.getTelefono(),
                usuarioEntity.getPassword(),
                usuarioEntity.getDireccion(),
                usuarioEntity.getFechaRegistro(),
                usuarioEntity.getEstado()
        );
    }

    public Usuario requestToDomain(UsuarioRequestDTO usuario){
        return new Usuario(
                null,
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getPassword(),
                usuario.getDireccion(),
                usuario.getFechaRegistro(),
                true
        );
    }

    public UsuarioResponseDTO domainToResponse(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getFechaRegistro(),
                usuario.getEstado()
        );
    }


}
