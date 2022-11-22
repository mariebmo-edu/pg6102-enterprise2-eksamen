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

    @Column(name = "buyer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val buyer: UserEntity,

    @Column(name = "price")
    val price: Long = 0,

    @Column(name = "order_placed")
    val orderPlaced: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "items_in_order")
    @OneToMany
    val itemsInOrder: List<ItemEntity> = listOf()
) {
}