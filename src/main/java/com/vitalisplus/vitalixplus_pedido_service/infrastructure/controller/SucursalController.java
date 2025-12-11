package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.SucursalService;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.SucursalRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.SucursalResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.SucursalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<SucursalResponseDTO>> mostrarSucursales() {
        List<Sucursal> sucursales = sucursalService.mostrarSucursales();
        List<SucursalResponseDTO> response = sucursales.stream()
                .map(sucursalMapper::domainToResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<SucursalResponseDTO> buscarSucursalporId(@PathVariable Long idSucursal) {
        Sucursal sucursal = sucursalService.buscarSucursalporId(idSucursal);
        SucursalResponseDTO response = sucursalMapper.domainToResponse(sucursal);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/{nombreSucursal}")
    public ResponseEntity<SucursalResponseDTO> buscarSucursalporNombre(@PathVariable String nombreSucursal) {
        Sucursal sucursal = sucursalService.buscarSucursalporNombre(nombreSucursal);
        SucursalResponseDTO response = sucursalMapper.domainToResponse(sucursal);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{idSucursal}")
    public ResponseEntity<SucursalResponseDTO> modificarSucursal(@PathVariable Long idSucursal, @RequestBody SucursalRequestDTO sucursalRequestDTO) {
        Sucursal sucursal = sucursalMapper.requestToDomain(sucursalRequestDTO);
        Sucursal sucursalModificada = sucursalService.modificarSucursal(idSucursal, sucursal);
        SucursalResponseDTO response = sucursalMapper.domainToResponse(sucursalModificada);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-status/{idSucursal}")
    public ResponseEntity<String> cambiarEstadoSucursal(@PathVariable Long idSucursal) {
        String mensaje = sucursalService.cambiarEstadoSucursal(idSucursal);
        return ResponseEntity.ok(mensaje);
    }


}
