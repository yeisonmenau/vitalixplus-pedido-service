package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class AuxiliarService implements AuxiliarRepository {
    private final AuxiliarRepository auxiliarRepository;
    @Override
    public Auxiliar crearAuxiliar(Auxiliar auxiliar) {
        return null;
    }

    @Override
    public List<Auxiliar> mostrarAuxiliares() {
        return List.of();
    }

    @Override
    public Auxiliar buscarAuxiliarporId(Long idAuxiliar) {
        return null;
    }

    @Override
    public Auxiliar modificarAuxiliar(Auxiliar auxiliar) {
        return null;
    }

    @Override
    public String cambiarEstadoAuxiliar() {
        return "";
    }
}
