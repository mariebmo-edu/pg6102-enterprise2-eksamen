package snr.student1012.paymentservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.paymentservice.model.PaymentEntity
import snr.student1012.paymentservice.repository.PaymentRepo

@Service
class PaymentService(@Autowired private val paymentRepo: PaymentRepo) {

    fun getPayments(): List<PaymentEntity>{
        return paymentRepo.findAll();
    }

    fun getPayment(id: Long): PaymentEntity?{
        return paymentRepo.findByIdOrNull(id);
    }

    fun registerPayment(paymentEntity: PaymentEntity): PaymentEntity?{
        return paymentRepo.save(paymentEntity);
    }

    fun updatePayment(paymentEntity: PaymentEntity): PaymentEntity?{
        return paymentRepo.save(paymentEntity);
    }

    fun deletePayment(id: Long){
        paymentRepo.deleteById(id);
    }
}