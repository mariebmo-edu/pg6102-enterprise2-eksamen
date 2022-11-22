package snr.student1012.orderservice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @SequenceGenerator(
        name = "users_user_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq")
    @Column(name = "user_id")
    val id: Long? = null,

    @Column(name = "user_email")
    val email: String,

    @Column(name = "user_password")
    val password: String,

    @Column(name = "user_created")
    val created: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "user_enabled")
    val enabled: Boolean? = true,
) {
}