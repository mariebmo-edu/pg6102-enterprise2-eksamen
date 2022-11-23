package snr.student1012.paymentservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import snr.student1012.paymentservice.model.TransactionEntity
import snr.student1012.paymentservice.repository.TransactionRepo

class TransactionService(@Autowired private val transactionRepo: TransactionRepo) {

    fun getTransactions(): List<TransactionEntity>{
        return transactionRepo.findAll();
    }

    fun getTransaction(id: Long): TransactionEntity?{
        return transactionRepo.findByIdOrNull(id);
    }

    fun registerTransaction(transactionEntity: TransactionEntity): Long?{
        return transactionRepo.save(transactionEntity).id;
    }

    fun updateTransaction(transactionEntity: TransactionEntity): TransactionEntity?{
        return transactionRepo.save(transactionEntity);
    }

    fun deleteTransaction(id: Long){
        transactionRepo.deleteById(id);
    }
}