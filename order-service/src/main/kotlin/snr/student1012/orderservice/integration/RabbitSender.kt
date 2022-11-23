package snr.student1012.orderservice.integration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import snr.student1012.orderservice.model.OrderEntity

@Service
class RabbitSender (@Autowired private val rabbitTemplate: RabbitTemplate){

    fun sendOrderToShippingService(orderEntity: OrderEntity){
        rabbitTemplate.convertAndSend("shipment_queue", "registerShipmentFromOrderId=${orderEntity.id}");
    }
}