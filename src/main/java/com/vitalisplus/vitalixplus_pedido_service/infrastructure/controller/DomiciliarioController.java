package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;


import com.vitalisplus.vitalixplus_pedido_service.application.service.DomiciliarioService;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.DomiciliarioRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.DomiciliarioResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.DomiciliarioMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
