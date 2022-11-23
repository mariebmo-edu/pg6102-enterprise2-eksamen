package snr.student1012.shippingservice.integration

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitSender (@Autowired private val rabbitTemplate: RabbitTemplate){

    fun sendOrderShipped(orderId: Long){
        rabbitTemplate.convertAndSend("order_queue", "shipmentRegisteredForOrderId=$orderId");
    }
}