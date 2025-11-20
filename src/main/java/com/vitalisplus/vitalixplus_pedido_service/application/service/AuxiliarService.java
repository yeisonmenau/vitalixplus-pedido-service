package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuxiliarService {
    private final AuxiliarRepository auxiliarRepository;

    public Auxiliar crearAuxiliar(Auxiliar auxiliar) {
        return auxiliarRepository.crearAuxiliar(auxiliar);
    }


    public List<Auxiliar> mostrarAuxiliares() {
        return auxiliarRepository.mostrarAuxiliares();
    }


    public Auxiliar buscarAuxiliarporId(Long idAuxiliar) {
        return auxiliarRepository.buscarAuxiliarporId(idAuxiliar);
    }


    public Auxiliar modificarAuxiliar(Auxiliar auxiliar) {
        return auxiliarRepository.modificarAuxiliar(auxiliar);
    }

    public String cambiarEstadoAuxiliar(Auxiliar auxiliar) {
        return auxiliarRepository.cambiarEstadoAuxiliar(auxiliar);
    }
}
