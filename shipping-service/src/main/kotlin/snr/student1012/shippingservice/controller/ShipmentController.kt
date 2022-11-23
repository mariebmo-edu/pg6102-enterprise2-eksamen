package snr.student1012.shippingservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

    @PostMapping("")
    fun registerShipment(@RequestBody shipmentEntity: ShipmentEntity?): ResponseEntity<Any>{
        when(shipmentEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                shipmentService.registerShipment(shipmentEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }


}