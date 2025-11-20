package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SucursalService{
    private final SucursalRepository sucursalRepository;

    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.crearSucursal(sucursal);
    }

}
