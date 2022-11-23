package snr.student1012.orderservice.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "orders")
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_order_id_seq")
    @SequenceGenerator(
        name = "orders_order_id_seq",
        allocationSize = 1
    )
    @Column(name = "order_id")
    val id: Long? = null,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "status")
    val status: String,

    @Column(name = "amount")
    val amount: Double,

    @Column(name = "currency")
    val currency: String = "NOK",

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
}