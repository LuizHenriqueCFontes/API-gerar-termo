package com.gerar.termo.exception.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timeStamp, Integer status, String error, String message) {

}
