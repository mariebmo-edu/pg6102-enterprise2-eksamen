package snr.student1012.orderservice.integrationtest.extension

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.http.ResponseEntity.ok
import snr.student1012.orderservice.dto.PaymentDto
import java.time.LocalDateTime


class WireMockExtension : BeforeAllCallback, AfterAllCallback {

    private val wm = WireMockServer(WireMockConfiguration().port(8080));

    override fun beforeAll(context: ExtensionContext?) {
        wv.start()

        wb.stubFor(
            post(urlEqualTo("/api/payment"))
                .willReturn(
                    ok(
                        PaymentDto(
                            1,
                            1,
                            299.0,
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            "COMPLETE"
                        )
                    )
                )
        )
    }

    override fun afterAll(context: ExtensionContext?) {
        wm.stop()
    }
}