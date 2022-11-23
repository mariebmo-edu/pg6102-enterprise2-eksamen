package snr.student1012.shippingservice.integration

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import snr.student1012.shippingservice.service.ShipmentService

@Service
@RabbitListener(queues = ["shipment_queue"])
class RabbitReceiver() {

    @RabbitHandler
    fun receiveMessage(message: String) {
        println("Received message: $message")
    }
}