package snr.student1012.orderservice.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import snr.student1012.orderservice.dto.ErrorResponseDto

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleEntityNotFoundException(exception: EntityNotFoundException): ResponseEntity<ErrorResponseDto> {

        val message = exception.message ?: "Entity not found"
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDto(HttpStatus.NOT_FOUND, message));
    }

    @ExceptionHandler
    fun handleServiceInterruptionException(exception: ServiceInterruptionException): ResponseEntity<ErrorResponseDto> {

        val message = exception.message ?: "Service interruption"
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, message));
    }

    @ExceptionHandler
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<ErrorResponseDto> {

        val message = exception.message ?: "Not valid request"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto(HttpStatus.BAD_REQUEST, message));
    }

    @ExceptionHandler
    fun handleEntityNotCreatedException(exception: EntityNotCreatedException): ResponseEntity<ErrorResponseDto> {
        val message = exception.message ?: "Error creating entity"
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, message));
    }

    @ExceptionHandler
    fun handleEntityNotUpdatedException(exception: EntityNotUpdatedException): ResponseEntity<ErrorResponseDto> {
        val message = exception.message ?: "Error updating entity"
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, message));
    }
}