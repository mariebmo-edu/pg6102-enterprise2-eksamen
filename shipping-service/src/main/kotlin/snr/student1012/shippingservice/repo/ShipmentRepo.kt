package snr.student1012.shippingservice.repo

import org.springframework.data.jpa.repository.JpaRepository
import snr.student1012.shippingservice.model.ShipmentEntity

interface ShipmentRepo : JpaRepository<ShipmentEntity, Long> {}