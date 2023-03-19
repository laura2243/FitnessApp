package com.example.demo.services;

import com.example.demo.dto.RegisterDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }


    /**
     * method that deletes a user resource
     * if the user deleted successfully it modifies the database otherwise
     * a message that the user does not exist
     */
    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id" + userId + "does not exists");

        }
        userRepository.deleteById(userId);
    }

    /**
     * method that updates a user's fields
     * if the user is update successfully it modifies the database otherwise
     * if the username or password is already taken an error message will be shown
     * and the changes will not be made
     */
    @Transactional
    public void updateUser(Integer userId, RegisterDto newUserEntity) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if(newUserEntity.getName() != null && newUserEntity.getName().length() > 0 && !Objects.equals(newUserEntity.getName(), userEntity.getName())){
            userEntity.setName(newUserEntity.getName());
        }
        if(newUserEntity.getEmail() != null && newUserEntity.getEmail().length() > 0 && !Objects.equals(newUserEntity.getEmail(), userEntity.getEmail())){
            Optional<UserEntity> userOptional = userRepository.findUserByEmail(newUserEntity.getEmail());
            if(userOptional.isPresent()){
                throw  new IllegalStateException("email taken");
            }
            userEntity.setEmail(newUserEntity.getEmail());
        }
        if(newUserEntity.getAge() != null && newUserEntity.getAge() > 0 && !Objects.equals(newUserEntity.getAge(), userEntity.getAge())){
            userEntity.setAge(newUserEntity.getAge());
        }
        if(newUserEntity.getKg() != null && newUserEntity.getKg() > 0 && !Objects.equals(newUserEntity.getKg(), userEntity.getKg())){
            userEntity.setKg(newUserEntity.getKg());
        }
        if(newUserEntity.getHeight() != null && newUserEntity.getHeight() > 0 && !Objects.equals(newUserEntity.getHeight(), userEntity.getHeight())){
            userEntity.setHeight(newUserEntity.getHeight());
        }

        userRepository.saveAndFlush(userEntity);

    }
}
