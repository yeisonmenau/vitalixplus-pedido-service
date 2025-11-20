package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out.UsuarioRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.UsuarioMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioRepository {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioJpaRepository usuarioJpaRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.domainToEntity(usuario);
        usuarioEntity.setEstado(true);
        UsuarioEntity UsuarioGuardado = usuarioJpaRepository.save(usuarioEntity);
        return usuarioMapper.entityToDomain(UsuarioGuardado);
    }

}
