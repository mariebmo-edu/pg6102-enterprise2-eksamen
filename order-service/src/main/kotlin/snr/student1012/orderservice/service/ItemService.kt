package snr.student1012.orderservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.orderservice.model.ItemEntity
import snr.student1012.orderservice.repository.ItemRepo
import java.util.*

@Service
class ItemService(@Autowired private val itemRepo: ItemRepo) {

    fun getItems(): List<ItemEntity>{
        return itemRepo.findAll();
    }

    fun getItem(id: Long): ItemEntity? {
        return itemRepo.findByIdOrNull(id);
    }

    fun registerItem(itemEntity: ItemEntity): Long?{
        return itemRepo.save(itemEntity).id;
    }
}