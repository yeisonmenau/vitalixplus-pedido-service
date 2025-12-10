package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;


import com.vitalisplus.vitalixplus_pedido_service.application.service.DomiciliarioService;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.DomiciliarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.DomiciliarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.DomiciliarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domiciliario")
@RequiredArgsConstructor
public class DomiciliarioController {
    private final DomiciliarioService domiciliarioService;
    private final DomiciliarioMapper domiciliarioMapper;

    @PostMapping
    public ResponseEntity<DomiciliarioResponseDTO> crearDomiciliario(DomiciliarioRequestDTO domiciliarioRequestDTO) {
        Domiciliario domiciliario = domiciliarioMapper.requestToDomain(domiciliarioRequestDTO);
        Domiciliario domiciliarioCreado = domiciliarioService.crearDomiciliario(domiciliario);
        DomiciliarioResponseDTO response = domiciliarioMapper.entityToResponse(domiciliarioCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DomiciliarioResponseDTO>> mostrarDomiciliarios() {
        List<Domiciliario> domiciliarios = domiciliarioService.mostrarDomiciliarios();
        List<DomiciliarioResponseDTO> response = domiciliarios.stream()
                .map(domiciliarioMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idAuxiliar}")
    public ResponseEntity<DomiciliarioResponseDTO> buscarDomiciliarioporId(Long idAuxiliar) {
        Domiciliario domiciliario = domiciliarioService.buscarDomiciliarioporId(idAuxiliar);
        DomiciliarioResponseDTO response = domiciliarioMapper.entityToResponse(domiciliario);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{idAuxiliar}")
    public ResponseEntity<DomiciliarioResponseDTO> modificarDomiciliario(@PathVariable Long idAuxiliar, @RequestBody DomiciliarioRequestDTO domiciliarioRequestDTO) {
        Domiciliario domiciliario = domiciliarioMapper.requestToDomain(domiciliarioRequestDTO);
        Domiciliario domiciliarioModificado = domiciliarioService.modificarDomiciliario(idAuxiliar, domiciliario);
        DomiciliarioResponseDTO response = domiciliarioMapper.entityToResponse(domiciliarioModificado);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-status/{idAuxiliar}")
    public ResponseEntity<String> cambiarEstadoDomiciliario(@PathVariable Long idAuxiliar) {
        String mensaje = domiciliarioService.cambiarEstadoDomiciliario(idAuxiliar);
        return ResponseEntity.ok(mensaje);
    }



}
