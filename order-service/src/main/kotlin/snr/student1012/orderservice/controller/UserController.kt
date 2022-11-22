package snr.student1012.orderservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import snr.student1012.orderservice.model.UserEntity
import snr.student1012.orderservice.service.UserService

@RestController
@RequestMapping("/api/order/user")
class UserController(@Autowired private val userService: UserService){

    @GetMapping("")
    fun getUsers() : ResponseEntity<List<UserEntity>> {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id : Long?) : ResponseEntity<Any> {
        id?.let {
            userService.getUser(id)?.let {
                return ResponseEntity.ok().body(it);
            }.run{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

    @PostMapping("")
    fun registerUser(@RequestBody userEntity: UserEntity?): ResponseEntity<Any> {
        when(userEntity){
            null -> return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            else -> {
                userService.registerUser(userEntity)?.let {
                    return ResponseEntity.ok().body(it);
                }.run{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
                }
            }
        }
    }
}