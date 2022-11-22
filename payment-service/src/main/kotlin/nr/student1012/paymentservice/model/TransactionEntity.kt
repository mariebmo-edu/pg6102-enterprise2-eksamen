package nr.student1012.paymentservice.model

import javax.persistence.*

@Entity
@Table(name = "transactions")
class TransactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_transaction_id_seq")
    @SequenceGenerator(
        name = "transactions_transaction_id_seq",
        allocationSize = 1
    )
    @Column(name = "transaction_id")
    val id: Long? = null,
) {
}