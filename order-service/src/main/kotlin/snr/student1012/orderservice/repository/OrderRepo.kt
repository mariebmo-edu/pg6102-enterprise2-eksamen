package snr.student1012.orderservice.repository

import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.domain.Pageable
import snr.student1012.orderservice.model.OrderEntity

interface OrderRepo : PagingAndSortingRepository<OrderEntity, Long> {

    override fun findAll(): List<OrderEntity>

    override fun findAll(pagable: Pageable): Page<OrderEntity>
}