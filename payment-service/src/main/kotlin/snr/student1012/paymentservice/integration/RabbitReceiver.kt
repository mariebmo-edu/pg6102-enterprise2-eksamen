package snr.student1012.paymentservice.integration

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
@RabbitListener(queues = ["order_queue"])
class RabbitReceiver {
    @RabbitHandler
    fun receiveMessage(message: String) {
        println("Received message: $message")
    }
}