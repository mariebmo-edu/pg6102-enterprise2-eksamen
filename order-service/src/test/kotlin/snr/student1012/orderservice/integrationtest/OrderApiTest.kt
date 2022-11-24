package snr.student1012.orderservice.integrationtest

import org.json.JSONObject
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import snr.student1012.orderservice.integrationtest.extension.WireMockExtension


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest")
@ExtendWith(WireMockExtension::class)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OrderApiTest(@Autowired private val mockMvc: MockMvc) {

    val baseUrl = "http://localhost:8080/api/order"

    @Test
    fun shouldCreateOrder() {
        val orderPayLoad = JSONObject()
        orderPayLoad.put("userId", 2)
        orderPayLoad.put("status", "WAITING")
        orderPayLoad.put("paymentStatus", "WAITING")
        orderPayLoad.put("totalPrice", 200.0)
        orderPayLoad.put("currency", "NOK")
        orderPayLoad.put("description", "cat")

        mockMvc.post(baseUrl){
            contentType = MediaType.APPLICATION_JSON
            content = orderPayLoad
        }
            .andExpect { status { isOk() } }
            .andReturn()
    }
}