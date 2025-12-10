package com.vitalisplus.vitalixplus_pedido_service.domain.usuario.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario crearUsuario (Usuario usuario);
    List<Usuario> mostrararUsuarios ();
    Usuario buscarUsuarioporId (Long idUsuario);
    Usuario modificarUsuario (Long idUsuario, Usuario usuario);
    String cambiarEstadoUsuario(Long idUsuario);
}