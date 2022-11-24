package snr.student1012.orderservice.integrationtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import snr.student1012.orderservice.model.OrderEntity
import snr.student1012.orderservice.service.OrderService

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(OrderService::class)
class OrderDatabaseIntegrationTest(@Autowired private val orderService: OrderService) {

    @Test
    fun shouldGetOrders() {
        val orders = orderService.getOrders()
        assert(orders.isNotEmpty())
    }

    @Test
    fun shouldGetOrder() {
        val order = orderService.getOrder(1)
        assert(order != null)
    }

    @Test
    fun shouldRegisterAndFindOrder(){
        val newOrderInfo = OrderEntity(null, 2, "WAITING", "WAITING", 200.0, "NOK", "cat")
        val createdOrder = orderService.registerOrder(newOrderInfo)

        assert(createdOrder?.description == newOrderInfo.description)

        val foundOrder = createdOrder?.id?.let { orderService.getOrder(it) }

        assert(foundOrder?.description == newOrderInfo.description)
    }

    @Test
    fun shouldDeleteOrder(){

        val newOrderInfo = OrderEntity(null, 2, "WAITING", "WAITING", 200.0, "NOK", "delete this")
        val createdOrder = orderService.registerOrder(newOrderInfo)
        assert(createdOrder?.description == newOrderInfo.description)

        createdOrder?.id?.let { orderService.deleteOrder(it) }
        createdOrder?.id?.let { assert(orderService.getOrder(it) == null) }
    }

    @Test
    fun shouldUpdateOrder(){
        val newOrderInfo = OrderEntity(null, 2, "WAITING", "WAITING", 200.0, "NOK", "update this")
        val createdOrder = orderService.registerOrder(newOrderInfo)

        createdOrder?.let {
            assert(createdOrder.description == newOrderInfo.description)

            createdOrder.description = "updated"

            val updatedOrder = orderService.updateOrder(createdOrder)

            updatedOrder?.let {
                assert(updatedOrder.description == "updated")
                assert(createdOrder.id == updatedOrder.id)
            }
        }
    }
}