package snr.student1012.paymentservice.exception

class PaymentNotFoundException(id: Long) : RuntimeException("Transaction with id $id not found") {
}