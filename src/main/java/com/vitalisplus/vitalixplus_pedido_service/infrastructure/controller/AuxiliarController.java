package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.AuxiliarService;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.AuxiliarRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.AuxiliarResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.AuxiliarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auxiliar")
@RequiredArgsConstructor
public class AuxiliarController  {
    private final AuxiliarService auxiliarService;
    private final AuxiliarMapper auxiliarMapper;

    @PostMapping
    public ResponseEntity<AuxiliarResponseDTO> crearAuxiliar(AuxiliarRequestDTO auxiliarRequestDTO) {
        Auxiliar auxiliar = auxiliarMapper.requestToDomain(auxiliarRequestDTO);
        Auxiliar auxiliarCreada = auxiliarService.crearAuxiliar(auxiliar);
        AuxiliarResponseDTO response = auxiliarMapper.domainToResponse(auxiliarCreada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuxiliarResponseDTO>> mostrarAuxiliares() {
        List<Auxiliar> auxiliares = auxiliarService.mostrarAuxiliares();
        List<AuxiliarResponseDTO> response = auxiliares.stream()
                .map(auxiliarMapper::domainToResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idAuxiliar}")
    public ResponseEntity<AuxiliarResponseDTO> buscarAuxiliarporId(@PathVariable Long idAuxiliar) {
        Auxiliar auxiliar = auxiliarService.buscarAuxiliarporId(idAuxiliar);
        AuxiliarResponseDTO response = auxiliarMapper.domainToResponse(auxiliar);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{idAuxiliar}")
    public ResponseEntity<AuxiliarResponseDTO> modificarAuxiliar(@PathVariable Long idAuxiliar, @RequestBody AuxiliarRequestDTO auxiliarRequestDTO) {
        Auxiliar auxiliar = auxiliarMapper.requestToDomain(auxiliarRequestDTO);
        Auxiliar auxiliarModificada = auxiliarService.modificarAuxiliar(idAuxiliar, auxiliar);
        AuxiliarResponseDTO response = auxiliarMapper.domainToResponse(auxiliarModificada);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-status/{idAuxiliar}")
    public ResponseEntity<String> cambiarEstadoAuxiliar(@PathVariable Long idAuxiliar) {
        Auxiliar auxiliar = auxiliarService.buscarAuxiliarporId(idAuxiliar);
        String mensaje = auxiliarService.cambiarEstadoAuxiliar(idAuxiliar);
        return ResponseEntity.ok(mensaje);
    }



}
