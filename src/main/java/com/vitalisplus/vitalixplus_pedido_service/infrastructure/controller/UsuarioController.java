package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.UsuarioService;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.UsuarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.UsuarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioMapper.requestToDomain(usuarioRequestDTO);
        Usuario usuarioGuardado = usuarioService.crearUsuario(usuario);
        UsuarioResponseDTO response = usuarioMapper.domainToResponse(usuarioGuardado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioResponseDTO>> mostrarUsuarios() {
        List<Usuario> usuarios = usuarioService.mostrararUsuarios();
        List<UsuarioResponseDTO> response = usuarios.stream()
                .map(usuarioMapper::domainToResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioporId(Long idUsuario) {
        Usuario usuario = usuarioService.buscarUsuarioporId(idUsuario);
        UsuarioResponseDTO response = usuarioMapper.domainToResponse(usuario);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{idUsuario}")
    public ResponseEntity<UsuarioResponseDTO> modificarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioMapper.requestToDomain(usuarioRequestDTO);
        Usuario usuarioModificado = usuarioService.modificarUsuario(idUsuario, usuario);
        UsuarioResponseDTO response = usuarioMapper.domainToResponse(usuarioModificado);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-status/{idUsuario}")
    public ResponseEntity<String> cambiarEstadoUsuario(@PathVariable Long idUsuario) {
        String mensaje = usuarioService.cambiarEstadoUsuario(idUsuario);
        return ResponseEntity.ok(mensaje);
    }


}
