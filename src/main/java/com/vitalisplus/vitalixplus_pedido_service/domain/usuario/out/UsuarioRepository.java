package com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario crearUsuario (Usuario usuario);
    List<Usuario> mostrarUsuarios ();
    Usuario buscarUsuarioporId (Long idUsuario);
    Usuario buscarUsuarioporEmail (String email);
    Usuario modificarUsuario (Usuario usuario);
    String cambiarEstadoUsuario();
}
