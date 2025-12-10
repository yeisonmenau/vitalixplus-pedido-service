package com.vitalisplus.vitalixplus_pedido_service.application.service;

import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SucursalService{
    private final SucursalRepository sucursalRepository;

    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.crearSucursal(sucursal);
    }

    public List<Sucursal> mostrarSucursales() {
        return sucursalRepository.mostrarSucursales();
    }

    public Sucursal buscarSucursalporId(Long idSucursal) {
        return sucursalRepository.buscarSucursalporId(idSucursal);
    }

    public Sucursal modificarSucursal(Long idSucursal, Sucursal sucursal) {
        return sucursalRepository.modificarSucursal(idSucursal, sucursal);
    }

    public String cambiarEstadoSucursal(Long idSucursal) {
        return sucursalRepository.cambiarEstadoSucursal(idSucursal);
    }

}
