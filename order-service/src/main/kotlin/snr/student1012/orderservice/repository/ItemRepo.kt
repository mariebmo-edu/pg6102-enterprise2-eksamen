package snr.student1012.orderservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import snr.student1012.orderservice.model.ItemEntity

interface ItemRepo : JpaRepository<ItemEntity, Long>{
}