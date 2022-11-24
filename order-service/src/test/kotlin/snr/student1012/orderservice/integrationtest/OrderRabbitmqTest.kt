package snr.student1012.orderservice.integrationtest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.containers.RabbitMQContainer;


@SpringJUnitConfig
@SpringRabbitTest
class OrderRabbitmqTest() {

    @Container
    val rabbitmqContainer = RabbitM

}