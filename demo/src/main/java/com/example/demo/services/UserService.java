package com.example.demo.services;

import com.example.demo.dto.RegisterDto;
import com.example.demo.interfaceService.UserServiceInterface;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {


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
    @Transactional
    public ResponseEntity<String> deleteUser(String userUsername) {
        userRepository.findUserEntityByUsername(userUsername).orElseThrow(() -> new IllegalStateException("user with id " + userUsername + " does not exist"));

        userRepository.deleteUserEntityByUsername(userUsername);
       return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

    /**
     * method that updates a user's fields
     * if the user is update successfully it modifies the database otherwise
     * if the username or password is already taken an error message will be shown
     * and the changes will not be made
     *
     * @return
     */
    @Transactional
    public UserEntity updateUser(Integer userId, RegisterDto newUserEntity) {
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
        return userEntity;

    }
}
