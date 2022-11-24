package snr.student1012.shippingservice.dto

import org.springframework.http.HttpStatus

data class ErrorResponseDto(
    val status: HttpStatus,
    val message: String,
    )