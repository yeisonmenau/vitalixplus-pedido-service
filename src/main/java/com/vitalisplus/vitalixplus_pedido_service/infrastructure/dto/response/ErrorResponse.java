package com.vitalisplus.vitalixplus_pedido_service.infrastructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private int status;
    private String message;
}
