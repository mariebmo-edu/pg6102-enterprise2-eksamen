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

    @NotNull
    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "transaction_created")
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "transaction_complete")
    val complete: LocalDateTime? = null
) {
}