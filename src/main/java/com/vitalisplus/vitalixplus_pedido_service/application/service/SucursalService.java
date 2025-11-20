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
        return sucursalRepository.crearSucursal(sucursal);
    }

}
