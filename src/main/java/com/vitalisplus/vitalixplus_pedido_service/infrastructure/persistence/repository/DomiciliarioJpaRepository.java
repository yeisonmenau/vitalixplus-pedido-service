package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository;

import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.DomiciliarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomiciliarioJpaRepository extends JpaRepository<DomiciliarioEntity, Long> {
}
