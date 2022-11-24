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
    val userId: Long? = null,

    @Column(name = "order_shipping_status")
    var shippingStatus: String = "CREATED",

    @Column(name = "order_payment_status")
    var paymentStatus: String = "PENDING",

    @Column(name = "order_amount")
    val amount: Double,

    @Column(name = "order_currency")
    val currency: String = "NOK",

    @Column(name = "order_description")
    val description: String? = null,

    @Column(name = "order_created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "order_updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
}