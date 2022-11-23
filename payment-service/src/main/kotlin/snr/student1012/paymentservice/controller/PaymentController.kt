package snr.student1012.paymentservice.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.paymentservice.model.PaymentEntity
import snr.student1012.paymentservice.service.PaymentService

@RestController
@RequestMapping("/api/payment")
class PaymentController(@Autowired private val paymentService: PaymentService) {

    @GetMapping("")
    fun getPayments() : ResponseEntity<List<PaymentEntity>> {
        return ResponseEntity.ok().body(paymentService.getPayments());
    }

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: Long?) : ResponseEntity<String>{
        id?.let {
            paymentService.getPayment(id)?.let {
                return ResponseEntity.ok().body(it.toString());
            }.run{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

    @PostMapping("")
    fun registerPayment(@RequestBody paymentEntity: PaymentEntity?): ResponseEntity<Any>{
        when(paymentEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                paymentService.registerPayment(paymentEntity)?.let {
                    val mapper = jacksonObjectMapper()
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }

    @PutMapping("")
    fun updatePayment(@RequestBody paymentEntity: PaymentEntity?): ResponseEntity<Any>{
        when(paymentEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                paymentService.updatePayment(paymentEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    fun deletePayment(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            paymentService.deletePayment(id)
            return ResponseEntity.ok().body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}