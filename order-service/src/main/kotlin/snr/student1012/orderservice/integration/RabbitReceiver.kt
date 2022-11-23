package snr.student1012.orderservice.integration

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import snr.student1012.orderservice.service.OrderService

@Service
@RabbitListener(queues = ["order_queue"])
class RabbitReceiver(@Autowired private val orderService: OrderService) {
    @RabbitHandler
    fun receiveMessage(message: String) {
        println("Received message: $message")

        if(message.startsWith("shipmentRegisteredForOrderId=")){
            //Not completely sure where to run this code
            val id = message.substring(29).toLong();
            var order = orderService.getOrder(id);

            order?.let {
                order.status = "Shipped";
                orderService.updateOrder(order)
            }
        }
    }
}