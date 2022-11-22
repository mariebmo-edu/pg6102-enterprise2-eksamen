package snr.student1012.orderservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.orderservice.model.ItemEntity
import snr.student1012.orderservice.service.ItemService

@RestController
@RequestMapping("/api/order/item")
class ItemController(@Autowired private val itemService: ItemService){

    @GetMapping("")
    fun getItems() : ResponseEntity<List<ItemEntity>> {
        return ResponseEntity.ok().body(itemService.getItems());
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable id : Long?) : ResponseEntity<Any> {
        id?.let {
            itemService.getItem(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

    @PostMapping("")
    fun registerItem(@RequestBody itemEntity: ItemEntity?):ResponseEntity<Any>{
        when(itemEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                itemService.registerItem(itemEntity)?.let {
                    println(itemEntity);
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }
}