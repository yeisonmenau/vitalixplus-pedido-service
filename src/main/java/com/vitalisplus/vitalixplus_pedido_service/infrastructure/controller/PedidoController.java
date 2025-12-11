package com.vitalisplus.vitalixplus_pedido_service.infrastructure.controller;

import com.vitalisplus.vitalixplus_pedido_service.application.service.PedidoService;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.EstadoPedido;
import com.vitalisplus.vitalixplus_pedido_service.domain.pedido.model.Pedido;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.request.PedidoRequestDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response.PedidoResponseDTO;
import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crearPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO){
        Pedido pedido = pedidoMapper.requestToDomain(pedidoRequestDTO);
        Pedido pedidoCreado = pedidoService.crearPedido(pedido);
        PedidoResponseDTO response = pedidoMapper.domainToResponse(pedidoCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoResponseDTO>> mostrarPedidos() {
        List<Pedido> pedidos = pedidoService.mostrarPedidos();
        List<PedidoResponseDTO> response = pedidos.stream()
                .map(pedidoMapper::domainToResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoporId(Long idPedido) {
        Pedido pedido = pedidoService.buscarPedidoporId(idPedido);
        PedidoResponseDTO response = pedidoMapper.domainToResponse(pedido);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{idPedido}")
    public ResponseEntity<PedidoResponseDTO> modificarPedido(@PathVariable Long idPedido, @RequestBody PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoMapper.requestToDomain(pedidoRequestDTO);
        Pedido pedidoModificado = pedidoService.modificarPedido(idPedido, pedido);
        PedidoResponseDTO response = pedidoMapper.domainToResponse(pedidoModificado);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-status/{idPedido}")
    public ResponseEntity<PedidoResponseDTO> modificarEstadoPedido(@PathVariable Long idPedido, @RequestBody EstadoPedido estado) {
        Pedido pedidoModificado = pedidoService.modificarEstadoPedido(idPedido, estado);
        PedidoResponseDTO response = pedidoMapper.domainToResponse(pedidoModificado);
        return ResponseEntity.ok(response);
    }
}
