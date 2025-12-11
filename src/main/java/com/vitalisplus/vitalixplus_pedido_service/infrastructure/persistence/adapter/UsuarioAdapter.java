package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.adapter;

import com.vitalisplus.vitalixplus_pedido_service.application.exception.UsuarioNotFoundException;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out.UsuarioRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.UsuarioMapper;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Usuario> mostrararUsuarios() {
        List<UsuarioEntity> usuariosRegistrados = usuarioJpaRepository.findAll();
        return usuariosRegistrados.stream()
                .map(usuarioMapper::entityToDomain)
                .toList();
    }

    @Override
    public Usuario buscarUsuarioporId(Long idUsuario) {
        UsuarioEntity existente = usuarioJpaRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + idUsuario));
        return usuarioMapper.entityToDomain(existente);
    }

    @Override
    public Usuario modificarUsuario(Long idUsuario, Usuario usuario) {
        UsuarioEntity existente = usuarioJpaRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + idUsuario));
        UsuarioEntity usuarioActualizado = usuarioMapper.domainToEntity(usuario);
        usuarioActualizado.setIdUsuario(existente.getIdUsuario());
        UsuarioEntity guardado = usuarioJpaRepository.save(usuarioActualizado);
        return usuarioMapper.entityToDomain(guardado);
    }

    @Override
    public String cambiarEstadoUsuario(Long idUsuario) {
        Usuario usuario = buscarUsuarioporId(idUsuario);
        usuario.setEstado(!usuario.getEstado());
        modificarUsuario(idUsuario, usuario);
        return "Se cambió el estado del usuario con id: " + idUsuario;
    }

//    @Override
//    public String buscarContraseñaporId(Long idUsuario) {
//        Usuario usuario = buscarUsuarioporId(idUsuario);
//        return usuario.getPassword();
//    }

}
