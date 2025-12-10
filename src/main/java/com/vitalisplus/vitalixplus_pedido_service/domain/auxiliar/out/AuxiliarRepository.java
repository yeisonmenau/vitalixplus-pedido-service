package com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.domiciliario.model.Domiciliario;

import java.util.List;

public interface AuxiliarRepository {
    Auxiliar crearAuxiliar (Auxiliar auxiliar);
    List<Auxiliar> mostrarAuxiliares ();
    Auxiliar buscarAuxiliarporId (Long idAuxiliar);
    Auxiliar modificarAuxiliar (Long idAuxiliar, Auxiliar auxiliar);
    String cambiarEstadoAuxiliar(Long idAuxiliar);
}
