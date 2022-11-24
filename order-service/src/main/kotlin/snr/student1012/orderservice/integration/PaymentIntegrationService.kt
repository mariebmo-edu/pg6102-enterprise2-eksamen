package snr.student1012.orderservice.integration

import org.springframework.beans.factory.annotation.Autowired
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hibernate.criterion.Order
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import snr.student1012.orderservice.dto.PaymentDto
import snr.student1012.orderservice.exception.ServiceInterruptionException
import snr.student1012.orderservice.model.OrderEntity
import java.time.LocalDateTime

@Service
class PaymentIntegrationService(@Autowired private val restTemplate: RestTemplate) {

    //val paymentUrl = "http://payment-service/api/payment";
    val paymentUrl = "http://payment-service/api/payment";

    fun sendOrderToPaymentService(orderEntity: OrderEntity) : OrderEntity? {
        orderEntity.id?.let {
            val paymentDto = PaymentDto(
                id = null,
                orderId = orderEntity.id,
                amount = orderEntity.amount,
                created = LocalDateTime.now(),
                updated = null,
                status = "PENDING"
            )

            try{
                val response = restTemplate.postForEntity(paymentUrl, paymentDto, PaymentDto::class.java);
                val returnedPaymentDto = response.body;
                returnedPaymentDto?.let {
                    orderEntity.paymentStatus = "PAID";
                    orderEntity.updatedAt = LocalDateTime.now();
                    return orderEntity;
                }
            }catch (e: Exception){
                throw ServiceInterruptionException("Payment service is not available");
            }
        }
        return null
    }
}