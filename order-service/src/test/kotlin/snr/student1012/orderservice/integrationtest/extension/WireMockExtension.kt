package snr.student1012.orderservice.integrationtest.extension

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
// import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.http.ResponseEntity.ok
import snr.student1012.orderservice.dto.PaymentDto
import java.time.LocalDateTime

/*WireMock is refusing to be added as dependency (com.github.tomakehurst), so the code isn't working. This is a preview of what I thought could work*/

class WireMockExtension : BeforeAllCallback, AfterAllCallback {

    /*
    private val wm = WireMockServer(WireMockConfiguration().port(8080));

    override fun beforeAll(context: ExtensionContext?) {
        wm.start()

        wm.stubFor(
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

     */
    override fun beforeAll(p0: ExtensionContext?) {
        TODO("Not yet implemented")
    }

    override fun afterAll(p0: ExtensionContext?) {
        TODO("Not yet implemented")
    }
}
