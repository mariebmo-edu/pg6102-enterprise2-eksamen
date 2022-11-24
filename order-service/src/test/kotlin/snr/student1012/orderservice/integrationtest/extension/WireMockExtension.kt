package snr.student1012.orderservice.integrationtest.extension

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.springframework.http.ResponseEntity.ok
import snr.student1012.orderservice.dto.PaymentDto
import java.time.LocalDateTime

class WireMockExtension : BeforeAllCallback, AfterAllCallback {


    private val wm = WireMockServer(WireMockConfiguration().port(8080));

    override fun beforeAll(context: ExtensionContext?) {

        val mapper = jacksonObjectMapper();
        jacksonObjectMapper().registerModule(JavaTimeModule());
        wm.start()

        wm.stubFor(
            post(urlEqualTo("/api/payment"))
                .willReturn(
                    WireMock.ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(jacksonObjectMapper().writeValueAsString(PaymentDto(1, 1, 299.99, LocalDateTime.now(), LocalDateTime.now(), "paid")))
                )
        )

    }

    override fun afterAll(context: ExtensionContext?) {
        wm.stop()
    }
}
