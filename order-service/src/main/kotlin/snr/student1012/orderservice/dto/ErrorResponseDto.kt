package snr.student1012.orderservice.dto

import org.springframework.http.HttpStatus

data class ErrorResponseDto(
    val status: HttpStatus,
    val message: String,
    )