package snr.student1012.paymentservice.dto

data class OrderDto(val id: Long, val userId: Long, val status: String, val amount: Double, val currency: String, val description: String?)