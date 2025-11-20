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
        return auxiliarRepository.crearAuxiliar(auxiliar);
    }

    @Override
    public List<Auxiliar> mostrarAuxiliares() {
        return auxiliarRepository.mostrarAuxiliares();
    }

    @Override
    public Auxiliar buscarAuxiliarporId(Long idAuxiliar) {
        return auxiliarRepository.buscarAuxiliarporId(idAuxiliar);
    }

    @Override
    public Auxiliar modificarAuxiliar(Auxiliar auxiliar) {
        return auxiliarRepository.modificarAuxiliar(auxiliar);
    }

    @Override
    public String cambiarEstadoAuxiliar(Auxiliar auxiliar) {
        return auxiliarRepository.cambiarEstadoAuxiliar(auxiliar);
    }
}
