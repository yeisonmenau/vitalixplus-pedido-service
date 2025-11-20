package com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.repository;

import com.vitalisplus.vitalixplus_pedido_service.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {
}
