package snr.student1012.shippingservice.exception

class ShipmentNotFoundException(id: Long) : RuntimeException("Shipment with id $id not found")