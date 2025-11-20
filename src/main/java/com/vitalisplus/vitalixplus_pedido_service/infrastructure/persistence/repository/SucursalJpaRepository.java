package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository;

import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalJpaRepository extends JpaRepository<SucursalEntity, Long> {
    SucursalEntity findByNombre(String nombre);
}
