package snr.student1012.paymentservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.paymentservice.exception.BadRequestException
import snr.student1012.paymentservice.exception.EntityNotFoundException
import snr.student1012.paymentservice.model.PaymentEntity
import snr.student1012.paymentservice.service.PaymentService

@RestController
@RequestMapping("/api/payment")
class PaymentController(@Autowired private val paymentService: PaymentService) {

    @GetMapping("")
    fun getPayments() : ResponseEntity<List<PaymentEntity>> {
        return ResponseEntity.ok().body(paymentService.getPayments())
    }

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: Long?) : ResponseEntity<String>{
        id?.let {
            paymentService.getPayment(id)?.let {
                return ResponseEntity.ok().body(it.toString())
            }.run{
                throw EntityNotFoundException("Payment with id $id not found")
            }
        }
        throw BadRequestException("Id is null")
    }

    @PostMapping("")
    fun registerPayment(@RequestBody paymentEntity: PaymentEntity?): ResponseEntity<Any>{
        when(paymentEntity){
            null -> throw BadRequestException("Payment is null")
            else -> {
                paymentService.registerPayment(paymentEntity)?.let {
                    return ResponseEntity.ok().body(it)
                }.run{
                    throw EntityNotFoundException("Payment not created")
                }
            }
        }
    }

    @PutMapping("")
    fun updatePayment(@RequestBody paymentEntity: PaymentEntity?): ResponseEntity<Any>{
        when(paymentEntity){
            null -> throw BadRequestException("Payment is null")
            else -> {
                paymentService.updatePayment(paymentEntity)?.let {
                    return ResponseEntity.ok().body(it)
                }.run{
                    throw EntityNotFoundException("Payment not updated")
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    fun deletePayment(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            paymentService.deletePayment(id)
            return ResponseEntity.ok().body("Deleted")
        }
        throw BadRequestException("Id is null")
    }
}