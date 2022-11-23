package snr.student1012.paymentservice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transactions")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_transaction_id_seq")
    @SequenceGenerator(
        name = "transactions_transaction_id_seq",
        allocationSize = 1
    )
    @Column(name = "transaction_id")
    val id: Long? = null,

    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "transaction_created")
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "transaction_complete")
    val complete: LocalDateTime? = null
) {
}