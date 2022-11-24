package snr.student1012.orderservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.orderservice.exception.EntityNotCreatedException
import snr.student1012.orderservice.exception.BadRequestException
import snr.student1012.orderservice.exception.EntityNotFoundException
import snr.student1012.orderservice.exception.EntityNotUpdatedException
import snr.student1012.orderservice.integration.PaymentIntegrationService
import snr.student1012.orderservice.integration.RabbitSender
import snr.student1012.orderservice.model.OrderEntity
import snr.student1012.orderservice.service.OrderService

@RestController
@RequestMapping("/api/order")
class OrderController(
    @Autowired private val orderService: OrderService,
    @Autowired private val paymentIntegrationService: PaymentIntegrationService,
    @Autowired private val rabbitSender: RabbitSender) {

    @GetMapping("")
    fun getOrders() : ResponseEntity<List<OrderEntity>> {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id : Long?) : ResponseEntity<Any> {
        id?.let {
            orderService.getOrder(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                throw EntityNotFoundException("Order with id $id not found");
            }
        }
        throw BadRequestException("Id is null");
    }

    @PostMapping("")
    fun registerOrder(@RequestBody orderEntity: OrderEntity?): ResponseEntity<Any> {
        when(orderEntity){
            null -> throw BadRequestException("Order is null")
            else -> {
                orderService.registerOrder(orderEntity)?.let {
                    paymentIntegrationService.sendOrderToPaymentService(it)?.let {
                        orderService.updateOrder(it)
                        rabbitSender.sendOrderToShippingService(it);
                        return ResponseEntity.ok().body(it);
                    }.run{
                        throw EntityNotCreatedException("Payment not created");
                    }
                }.run{
                    throw EntityNotCreatedException("Order not created");
                }
            }
        }
    }

    @PutMapping("")
    fun updateOrder(@RequestBody orderEntity: OrderEntity?): ResponseEntity<Any> {
        when(orderEntity){
            null -> throw BadRequestException("Order is null")
            else -> {
                orderService.updateOrder(orderEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    throw EntityNotUpdatedException("Error updating order");
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Long?) : ResponseEntity<Any> {
        id?.let {
            orderService.deleteOrder(id)
            return ResponseEntity.ok().body("Deleted");
            }.run{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
        }
    }
}