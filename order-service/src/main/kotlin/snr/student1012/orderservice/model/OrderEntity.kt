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

    /*
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "buyer_id", referencedColumnName = "user_id")
    val buyer: UserEntity,
     */

    @Column(name="order_paid")
    val orderPaid: Boolean = false,

    @Column(name="order_shipped")
    val orderShipped: Boolean = false,


    @Column(name = "order_total")
    val orderTotal: Long = 0,

    @Column(name = "order_created")
    val orderCreated: LocalDateTime = LocalDateTime.now()

    /*
    @Column(name = "items_in_order")
    @OneToMany
    val itemsInOrder: List<ItemEntity> = listOf()
     */
) {
}