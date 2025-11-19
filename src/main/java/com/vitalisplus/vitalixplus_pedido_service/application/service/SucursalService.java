package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class SucursalService implements SucursalRepository {
    private final SucursalRepository sucursalRepository;
    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
        return null;
    }

    @Override
    public Sucursal buscarSucursalporId(Long idSucursal) {
        return null;
    }

    @Override
    public List<Sucursal> mostrarSucursales() {
        return List.of();
    }

    @Override
    public Sucursal modificarSucursal(Sucursal sucursal) {
        return null;
    }

    @Override
    public String cambiarEstadoSucursal() {
        return "";
    }
}
