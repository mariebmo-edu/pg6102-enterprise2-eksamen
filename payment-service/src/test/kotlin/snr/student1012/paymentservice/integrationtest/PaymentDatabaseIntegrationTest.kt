package snr.student1012.paymentservice.integrationtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import snr.student1012.paymentservice.model.PaymentEntity
import snr.student1012.paymentservice.service.PaymentService
import java.time.LocalDateTime

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(PaymentService::class)
class PaymentDatabaseIntegrationTest(@Autowired private val paymentService: PaymentService) {

    @Test
    fun shouldGetPayments() {
        val payments = paymentService.getPayments()
        assert(payments.isNotEmpty())
    }

    @Test
    fun shouldGetPayment() {
        val payment = paymentService.getPayment(1)
        assert(payment != null)
    }

    @Test
    fun shouldRegisterAndFindPayment(){
        val newPaymentInfo = PaymentEntity(null, 1, 299.9, LocalDateTime.now(), LocalDateTime.now(), "WAITING")
        val createdPayment = paymentService.registerPayment(newPaymentInfo)

        assert(createdPayment?.amount == newPaymentInfo.amount)

        val foundPayment = createdPayment?.id?.let { paymentService.getPayment(it) }

        assert(foundPayment?.amount == newPaymentInfo.amount)
    }

    @Test
    fun shouldDeletePayment(){

        val newPaymentInfo = PaymentEntity(null, 1, 299.9, LocalDateTime.now(), LocalDateTime.now(), "WAITING")
        val createdPayment = paymentService.registerPayment(newPaymentInfo)
        assert(createdPayment?.amount == newPaymentInfo.amount)

        createdPayment?.id?.let { paymentService.deletePayment(it) }
        createdPayment?.id?.let { assert(paymentService.getPayment(it) == null) }
    }

    @Test
    fun shouldUpdatePayment(){
        val newPaymentInfo = PaymentEntity(null, 1, 299.9, LocalDateTime.now(), LocalDateTime.now(), "WAITING")
        val createdPayment = paymentService.registerPayment(newPaymentInfo)

        createdPayment?.let {
            assert(createdPayment.amount == newPaymentInfo.amount)

            createdPayment.amount = 399.9

            val updatedPayment = paymentService.updatePayment(createdPayment)

            updatedPayment?.let {
                assert(updatedPayment.amount == createdPayment.amount)
            }
        }
    }
}