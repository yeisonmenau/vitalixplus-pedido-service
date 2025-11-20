package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.SucursalService;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.SucursalRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.SucursalResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.SucursalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalController {
    private final SucursalService sucursalService;
    private final SucursalMapper sucursalMapper;

    @PostMapping
    public ResponseEntity<SucursalResponseDTO> crearSucursal(SucursalRequestDTO sucursalRequestDTO) {
        Sucursal sucursal = sucursalMapper.requestToDomain(sucursalRequestDTO);
        Sucursal sucursalCreada = sucursalService.crearSucursal(sucursal);
        SucursalResponseDTO response = sucursalMapper.domainToResponse(sucursalCreada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
