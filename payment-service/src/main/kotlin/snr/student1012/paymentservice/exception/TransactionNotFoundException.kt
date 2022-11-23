package snr.student1012.paymentservice.exception

class TransactionNotFoundException(id: Long) : RuntimeException("Transaction with id $id not found") {
}