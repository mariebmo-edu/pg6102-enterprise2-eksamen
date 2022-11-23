package snr.student1012.shippingservice.integration

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import snr.student1012.paymentservice.dto.OrderDto
import snr.student1012.shippingservice.service.ShipmentService

@Service
@RabbitListener(queues = ["shipment_queue"])
class RabbitReceiver(@Autowired private val shipmentService: ShipmentService) {

    @RabbitHandler
    fun receiveMessage(message: String) {
        println("Received message: $message")

        if(message.startsWith("registerShipmentFromOrderId=")){
            //Not completely sure where to run this code
            shipmentService.registerShipmentFromOrderId(message.substring(28).toLong());
        }

    }
}