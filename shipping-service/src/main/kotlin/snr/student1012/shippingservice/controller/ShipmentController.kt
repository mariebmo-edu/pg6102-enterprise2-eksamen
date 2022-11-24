package snr.student1012.shippingservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.shippingservice.exception.BadRequestException
import snr.student1012.shippingservice.exception.EntityNotFoundException
import snr.student1012.shippingservice.model.ShipmentEntity
import snr.student1012.shippingservice.service.ShipmentService

@RestController
@RequestMapping("/api/shipping")
class ShipmentController(@Autowired private val shipmentService: ShipmentService) {

    @GetMapping("")
    fun getShipments() : ResponseEntity<List<ShipmentEntity>>{
        return ResponseEntity.ok().body(shipmentService.getShipments());
    }

    @GetMapping("/{id}")
    fun getShipmentById(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            shipmentService.getShipment(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                throw EntityNotFoundException("Shipment with id $id not found")
            }
        }
        throw BadRequestException("Id is null")
    }

    @PostMapping("")
    fun registerShipment(@RequestBody shipmentEntity: ShipmentEntity?): ResponseEntity<Any>{
        when(shipmentEntity){
            null -> throw BadRequestException("Shipment is null")
            else -> {
                shipmentService.registerShipment(shipmentEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    throw EntityNotFoundException("Shipment not created")
                }
            }
        }
    }

    @PutMapping("")
    fun updateShipment(@RequestBody shipmentEntity: ShipmentEntity?): ResponseEntity<Any>{
        when(shipmentEntity){
            null -> throw BadRequestException("Shipment is null")
            else -> {
                shipmentService.updateShipment(shipmentEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    throw EntityNotFoundException("Shipment not updated")
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    fun deleteShipment(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            shipmentService.deleteShipment(id)
            return ResponseEntity.ok().body("Deleted");
        }
        throw BadRequestException("Id is null")
    }


}