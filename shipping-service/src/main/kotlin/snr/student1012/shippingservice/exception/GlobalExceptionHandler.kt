package snr.student1012.shippingservice.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import snr.student1012.shippingservice.dto.ErrorResponseDto

@ControllerAdvice
class GlobalExceptionHandler {

    fun handleEntityNotFoundException(exception: EntityNotFoundException): ResponseEntity<ErrorResponseDto> {
        val message = exception.message ?: "Entity not found"
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDto(HttpStatus.NOT_FOUND, message));
    }

    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<ErrorResponseDto> {
        val message = exception.message ?: "Not valid request"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto(HttpStatus.BAD_REQUEST, message));
    }
}