package com.example.demo.user;

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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id" + userId + "does not exists");

        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, User newUser) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if(newUser.getName() != null && newUser.getName().length() > 0 && !Objects.equals(newUser.getName(),user.getName())){
            user.setName(newUser.getName());
        }
        if(newUser.getEmail() != null && newUser.getEmail().length() > 0 && !Objects.equals(newUser.getEmail(),user.getEmail())){
            Optional<User> userOptional = userRepository.findUserByEmail(newUser.getEmail());
            if(userOptional.isPresent()){
                throw  new IllegalStateException("email taken");
            }
            user.setEmail(newUser.getEmail());
        }
        if(newUser.getAge() != null && newUser.getAge() > 0 && !Objects.equals(newUser.getAge(), user.getAge())){
            user.setAge(newUser.getAge());
        }
        if(newUser.getKg() != null && newUser.getKg() > 0 && !Objects.equals(newUser.getKg(), user.getKg())){
            user.setKg(newUser.getKg());
        }
        if(newUser.getHeight() != null && newUser.getHeight() > 0 && !Objects.equals(newUser.getHeight(), user.getHeight())){
            user.setHeight(newUser.getHeight());
        }

        userRepository.saveAndFlush(user);

    }
}
