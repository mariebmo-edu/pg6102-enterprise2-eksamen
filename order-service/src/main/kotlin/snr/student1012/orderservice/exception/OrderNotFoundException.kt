package snr.student1012.orderservice.exception

class OrderNotFoundException(id: Long) : RuntimeException("Order with id $id not found")