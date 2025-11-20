package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.UsuarioService;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.UsuarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.UsuarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
