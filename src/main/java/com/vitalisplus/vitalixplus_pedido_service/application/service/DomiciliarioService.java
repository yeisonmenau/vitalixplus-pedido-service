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
        return null;
    }

    @Override
    public List<Domiciliario> mostrarDomiciliarios() {
        return List.of();
    }

    @Override
    public Domiciliario buscarDomiciliarioporId(Long idDomiciliario) {
        return null;
    }

    @Override
    public Domiciliario modificarDomiciliario(Domiciliario domiciliario) {
        return null;
    }

    @Override
    public String cambiarEstadoDomiciliario() {
        return "";
    }
}
