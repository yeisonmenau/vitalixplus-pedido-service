package com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;

import java.util.List;

public interface DomiciliaroRepository {
    Domiciliario crearDomiciliario (Domiciliario domiciliario);
    List<Domiciliario> mostrarDomiciliarios ();
    Domiciliario buscarDomiciliarioporId (Long idDomiciliario);
    Domiciliario modificarDomiciliario (Domiciliario domiciliario);
    String cambiarEstadoDomiciliario();
}
