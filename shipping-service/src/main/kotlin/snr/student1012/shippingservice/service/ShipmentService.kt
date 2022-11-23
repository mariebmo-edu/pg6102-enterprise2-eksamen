package snr.student1012.shippingservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.shippingservice.integration.RabbitSender
import snr.student1012.shippingservice.model.ShipmentEntity
import snr.student1012.shippingservice.repo.ShipmentRepo

@Service
class ShipmentService (@Autowired private val shipmentRepo: ShipmentRepo, @Autowired private val rabbitSender: RabbitSender) {

    fun getShipments() : List<ShipmentEntity>{
        return shipmentRepo.findAll();
    }

    fun getShipment(id: Long) : ShipmentEntity? {
        return shipmentRepo.findByIdOrNull(id);
    }

    fun registerShipment(shipmentEntity: ShipmentEntity) : ShipmentEntity?{
        return shipmentRepo.save(shipmentEntity);
    }

    fun registerShipmentFromOrderId(orderId: Long) : ShipmentEntity?{
        val shipmentEntity = ShipmentEntity(orderId = orderId)

        val shipment = shipmentRepo.save(shipmentEntity);

        shipment.orderId?.let { rabbitSender.sendOrderShipped(it) }

        return shipment;
    }

    fun updateShipment(shipmentEntity: ShipmentEntity) : Long?{
        return shipmentRepo.save(shipmentEntity).id;
    }

    fun deleteShipment(id: Long) {
        shipmentRepo.deleteById(id);
    }
}