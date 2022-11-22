package snr.student1012.orderservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import snr.student1012.orderservice.model.UserEntity
import snr.student1012.orderservice.repository.UserRepo
import java.util.*

@Service
class UserService(@Autowired private val userRepo: UserRepo) {

    fun getUsers() : List<UserEntity>{
        return userRepo.findAll();
    }

    fun getUser(id: Long) : UserEntity? {
        return userRepo.findByIdOrNull(id);
    }

    fun registerUser(userEntity: UserEntity) : Long? {
        return userRepo.save(userEntity).id;
    }
}