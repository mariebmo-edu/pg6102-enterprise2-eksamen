package snr.student1012.orderservice.integration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class PaymentIntegrationService(@Autowired private val restTemplate: RestTemplate) {

    val paymentUrl = "http://payment-service/api/payment";

    fun sendHttpCallToPaymentService(id: Long): ResponseEntity<String> {
        val response: ResponseEntity<String> = restTemplate.getForEntity("$paymentUrl/transaction/$id", ResponseEntity::class);
        println("response from payment service: ${response.body}");
        return response;
    }
}