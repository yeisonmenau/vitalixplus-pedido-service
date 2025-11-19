package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class UsuarioService implements UsuarioRepository {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return List.of();
    }

    @Override
    public Usuario buscarUsuarioporId(Long idUsuario) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioporEmail(String email) {
        return null;
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public String cambiarEstadoUsuario() {
        return "";
    }
}
