package snr.student1012.orderservice.integration

import org.springframework.beans.factory.annotation.Autowired
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import snr.student1012.orderservice.dto.PaymentDto
import snr.student1012.orderservice.model.OrderEntity
import java.time.LocalDateTime

@Service
class PaymentIntegrationService(@Autowired private val restTemplate: RestTemplate) {

    val paymentUrl = "http://payment-service/api/payment";
    //val paymentUrl = "http://localhost:8080/api/payment";

    fun sendOrderToPaymentService(orderEntity: OrderEntity) : OrderEntity? {
        orderEntity.id?.let {
            val paymentDto = PaymentDto(
                id = null,
                orderId = orderEntity.id,
                amount = orderEntity.amount,
                created = LocalDateTime.now(),
                complete = null
            )

            try{
                val response = restTemplate.postForEntity(paymentUrl, paymentDto, PaymentDto::class.java);
                val returnedPaymentDto = response.body;
                returnedPaymentDto?.let {
                    orderEntity.paymentStatus = "Payment complete";
                    return orderEntity;
                }
            }catch (e: Exception){
                println(e);
            }
        }

        return null
    }


}