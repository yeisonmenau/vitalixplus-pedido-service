package com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out;

import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.model.Auxiliar;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.model.Sucursal;
import com.vitalisplus.vitalixplus_pedido_service.domain.usuario.model.Usuario;

import java.util.List;

public interface SucursalRepository {
    Sucursal crearSucursal (Sucursal sucursal);
    List<Sucursal> mostrarSucursales ();
    Sucursal buscarSucursalporId (Long idSucursal);
    Sucursal modificarSucursal (Long idSucursal, Sucursal sucursal);
    String cambiarEstadoSucursal(Long idSucursal);
}