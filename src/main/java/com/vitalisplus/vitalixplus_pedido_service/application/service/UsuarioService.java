package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService{
    private final UsuarioRepository usuarioRepository;


    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.crearUsuario(usuario);
    }
    public List<Usuario> mostrararUsuarios() {
        return usuarioRepository.mostrararUsuarios();
    }
    public Usuario buscarUsuarioporId(Long idUsuario) {
        return usuarioRepository.buscarUsuarioporId(idUsuario);
    }
    public Usuario modificarUsuario(Long idUsuario, Usuario usuario) {
        return usuarioRepository.modificarUsuario(idUsuario, usuario);
    }
    public String cambiarEstadoUsuario(Long idUsuario) {
        return usuarioRepository.cambiarEstadoUsuario(idUsuario);
    }

}
