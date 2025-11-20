package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.out.DomiciliaroRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class DomiciliarioService implements DomiciliaroRepository {
    private final DomiciliaroRepository domiciliaroRepository;
    @Override
    public Domiciliario crearDomiciliario(Domiciliario domiciliario) {
        return domiciliaroRepository.crearDomiciliario(domiciliario);
    }

    @Override
    public List<Domiciliario> mostrarDomiciliarios() {
        return domiciliaroRepository.mostrarDomiciliarios();
    }

    @Override
    public Domiciliario buscarDomiciliarioporId(Long idDomiciliario) {
        return domiciliaroRepository.buscarDomiciliarioporId(idDomiciliario);
    }

    @Override
    public Domiciliario modificarDomiciliario(Long idDomiciliario, Domiciliario domiciliario) {
        return domiciliaroRepository.modificarDomiciliario(idDomiciliario,domiciliario);
    }

    @Override
    public String cambiarEstadoDomiciliario(Long idDomiciliario) {
        return domiciliaroRepository.cambiarEstadoDomiciliario(idDomiciliario);
    }
}
