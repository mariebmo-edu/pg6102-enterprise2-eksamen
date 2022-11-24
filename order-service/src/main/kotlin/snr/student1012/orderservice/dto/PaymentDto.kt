package snr.student1012.orderservice.dto

import java.time.LocalDateTime

data class PaymentDto (
    val id: Long?,
    val orderId: Long,
    val amount: Double,
    val created: LocalDateTime?,
    val updated: LocalDateTime?,
    val status: String
    )