package snr.student1012.orderservice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "items")
class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_item_id_seq")
    @SequenceGenerator(
        name = "items_item_id_seq",
        allocationSize = 1
    )
    @Column(name = "item_id")
    val id: Long? = null,

    @Column(name = "item_name")
    val name: Long? = null,

    @Column(name = "item_price")
    val price: Long = 0,

    @Column(name = "item_added")
    val orderPlaced: LocalDateTime? = LocalDateTime.now()

) {}