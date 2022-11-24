package snr.student1012.shippingservice.integrationtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import snr.student1012.shippingservice.model.ShipmentEntity
import snr.student1012.shippingservice.service.ShipmentService
import java.time.LocalDateTime

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(ShipmentService::class)
class ShipmentDatabaseIntegrationTest(@Autowired private val shipmentService: ShipmentService){

    @Test
    fun shouldGetShipments() {
        val shipments = shipmentService.getShipments()
        assert(shipments.isNotEmpty())
    }

    @Test
    fun shouldGetShipment() {
        val shipment = shipmentService.getShipment(1)
        assert(shipment != null)
    }

    @Test
    fun shouldRegisterAndFindShipment(){
        val newShipmentInfo = ShipmentEntity(null, 1, LocalDateTime.now(), LocalDateTime.now(), "WAITING")
        val createdShipment = shipmentService.registerShipment(newShipmentInfo)

        assert(createdShipment?.status == newShipmentInfo.status)

        val foundShipment = createdShipment?.id?.let { shipmentService.getShipment(it) }

        assert(foundShipment?.status == newShipmentInfo.status)
    }

    @Test
    fun shouldDeleteShipment(){

        val newShipmentInfo = ShipmentEntity(null, 1, LocalDateTime.now(), LocalDateTime.now(), "WAITING")
        val createdShipment = shipmentService.registerShipment(newShipmentInfo)
        assert(createdShipment?.status == newShipmentInfo.status)

        createdShipment?.id?.let { shipmentService.deleteShipment(it) }

        createdShipment?.id?.let { assert(shipmentService.getShipment(it) == null) }
    }
}