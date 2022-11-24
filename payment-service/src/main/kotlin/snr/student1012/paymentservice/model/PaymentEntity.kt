package snr.student1012.paymentservice.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "payments")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_payment_id_seq")
    @SequenceGenerator(
        name = "payments_payment_id_seq",
        allocationSize = 1
    )
    @Column(name = "payment_id")
    val id: Long? = null,

    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "payment_amount")
    val amount: Double? = 0.0,

    @Column(name = "payment_created_at")
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "payment_updated_at")
    val updated: LocalDateTime= LocalDateTime.now(),

    @Column(name = "payment_status")
    val status: String = "PENDING"
) {
}