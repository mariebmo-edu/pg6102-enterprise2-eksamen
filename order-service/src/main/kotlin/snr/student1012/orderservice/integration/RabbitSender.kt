package snr.student1012.orderservice.integration

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitSender (@Autowired private val rabbitTemplate: RabbitTemplate){

    fun sendMessage(message: String){
        rabbitTemplate.convertAndSend("order_queue", message);
    }

    fun sendOrderToShippingService(orderId: Long){
        rabbitTemplate.convertAndSend("shipment_queue", orderId.toString());
    }
}