package snr.student1012.shippingservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.shippingservice.model.ShipmentEntity
import snr.student1012.shippingservice.repo.ShipmentRepo

@Service
class ShipmentService (@Autowired private val shipmentRepo: ShipmentRepo) {

    fun getShipments() : List<ShipmentEntity>{
        return shipmentRepo.findAll();
    }

    fun getShipment(id: Long) : ShipmentEntity? {
        return shipmentRepo.findByIdOrNull(id);
    }

    fun registerShipment(shipmentEntity: ShipmentEntity) : Long?{
        return shipmentRepo.save(shipmentEntity).id;
    }

    fun updateShipment(shipmentEntity: ShipmentEntity) : Long?{
        return shipmentRepo.save(shipmentEntity).id;
    }

    fun deleteShipment(id: Long) {
        shipmentRepo.deleteById(id);
    }
}