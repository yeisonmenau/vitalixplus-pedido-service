package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.out.DomiciliarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DomiciliarioService{
    private final DomiciliarioRepository domiciliarioRepository;

    public Domiciliario crearDomiciliario(Domiciliario domiciliario) {
        return domiciliarioRepository.crearDomiciliario(domiciliario);
    }


    public List<Domiciliario> mostrarDomiciliarios() {
        return domiciliarioRepository.mostrarDomiciliarios();
    }

    public Domiciliario buscarDomiciliarioporId(Long idDomiciliario) {
        return domiciliarioRepository.buscarDomiciliarioporId(idDomiciliario);
    }

    public Domiciliario modificarDomiciliario(Long idDomiciliario, Domiciliario domiciliario) {
        return domiciliarioRepository.modificarDomiciliario(idDomiciliario,domiciliario);
    }

    public String cambiarEstadoDomiciliario(Long idDomiciliario) {
        return domiciliarioRepository.cambiarEstadoDomiciliario(idDomiciliario);
    }
}
