package snr.student1012.shippingservice.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shipments")
class ShipmentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipments_shipment_id_seq")
    @SequenceGenerator(
        name = "shipments_shipment_id_seq",
        allocationSize = 1
    )
    @Column(name = "shipment_id")
    val id: Long? = null,

    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "shipment_created_at")
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "shipment_updated_at")
    val updated: LocalDateTime= LocalDateTime.now(),

    @Column(name = "shipment_status")
    val status: String = "CREATED",
) {
}