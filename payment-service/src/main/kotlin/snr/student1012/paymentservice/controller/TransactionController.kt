package snr.student1012.paymentservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import snr.student1012.paymentservice.service.TransactionService

@RestController
@RequestMapping("/api/payment/transaction")
class TransactionController(@Autowired private val transactionService: TransactionService) {

    @GetMapping("")
    fun getTransactions() : ResponseEntity<List<TransactionEntity>>{
        return ResponseEntity.ok().body(transactionService.getTransactions());
    }

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            transactionService.getTransaction(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

    @PostMapping("")
    fun registerTransaction(@RequestBody transactionEntity: TransactionEntity?): ResponseEntity<Any>{
        when(transactionEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                transactionService.registerTransaction(transactionEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }

    @PutMapping("")
    fun updateTransaction(@RequestBody transactionEntity: TransactionEntity?): ResponseEntity<Any>{
        when(transactionEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                transactionService.updateTransaction(transactionEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTransaction(@PathVariable id: Long?) : ResponseEntity<Any>{
        id?.let {
            transactionService.deleteTransaction(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }
}