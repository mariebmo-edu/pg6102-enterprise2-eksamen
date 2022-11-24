package snr.student1012.orderservice.integrationtest

import org.junit.jupiter.api.Test
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
//import org.testcontainers.containers.RabbitMQContainer;



@SpringJUnitConfig
class OrderRabbitmqTest(@Autowired private val rabbitTemplate: RabbitTemplate, @Autowired private val rabbitAdmin: RabbitAdmin, @Autowired private val registry : RabbitListenerEndpointRegistry) {

    val amqpsPort = 5671;
    val httpsPort = 15671;


}

