package com.vitalisplus.vitalixplus_pedido_service.infrastructure.configuration;

import com.vitalisplus.vitalixplus_pedido_service.application.service.AuxiliarService;
import com.vitalisplus.vitalixplus_pedido_service.application.service.SucursalService;
import com.vitalisplus.vitalixplus_pedido_service.domain.auxiliar.out.AuxiliarRepository;
import com.vitalisplus.vitalixplus_pedido_service.domain.sucursal.out.SucursalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean
    public AuxiliarService auxiliarServiceBean(AuxiliarRepository auxiliarRepository) {
        return new AuxiliarService(auxiliarRepository);
    }
    @Bean
    public SucursalService sucursalService(SucursalRepository sucursalRepository){
        return new SucursalService(sucursalRepository);
    }
}
