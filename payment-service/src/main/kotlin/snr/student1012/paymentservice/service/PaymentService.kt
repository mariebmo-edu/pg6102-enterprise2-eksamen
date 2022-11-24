package snr.student1012.paymentservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.paymentservice.model.PaymentEntity
import snr.student1012.paymentservice.repository.PaymentRepo

@Service
@CacheConfig(cacheNames = ["payment"])
class PaymentService(@Autowired private val paymentRepo: PaymentRepo) {

    //There's not really a point in caching this, but it's here for demonstration purposes. Once a payment is complete, it's not going to change.

    @Cacheable
    fun getPayments(): List<PaymentEntity>{
        return paymentRepo.findAll();
    }

    fun getPayment(page: Int) : Page<PaymentEntity>{
        return paymentRepo.findAll(Pageable.ofSize(5).withPage(page));
    }

    @Cacheable
    fun getPayment(id: Long): PaymentEntity?{
        return paymentRepo.findByIdOrNull(id);
    }

    @CacheEvict(key = "#paymentEntity.id")
    fun registerPayment(paymentEntity: PaymentEntity): PaymentEntity?{
        return paymentRepo.save(paymentEntity);
    }

    @CacheEvict(key = "#paymentEntity.id")
    fun updatePayment(paymentEntity: PaymentEntity): PaymentEntity?{
        return paymentRepo.save(paymentEntity);
    }

    @CacheEvict(key = "#id")
    fun deletePayment(id: Long){
        paymentRepo.deleteById(id);
    }
}