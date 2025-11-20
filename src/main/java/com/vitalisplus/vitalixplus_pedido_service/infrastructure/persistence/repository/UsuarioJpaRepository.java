package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository;

import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
