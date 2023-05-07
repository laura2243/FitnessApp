package com.example.demo;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.interfaceService.UserServiceInterface;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserTests {


    @Mock
    private UserRepository userRepository;


    @Test
    public void getAllUsers_success() {

        UserServiceInterface userServiceInterface = new UserService(userRepository);

        UserEntity userEntity = new UserEntity("ana", "ana", 5, 5, 5, "username", "pass");
        UserEntity userEntity2 = new UserEntity("ana1", "ana1", 5, 5, 5, "username", "pass");

        List<UserEntity> users = new ArrayList<>(Arrays.asList(
                userEntity, userEntity2
        ));

        when(userRepository.findAll()).thenReturn(users);

        List<UserEntity> userEntities = userServiceInterface.getUsers();

        assertEquals(userEntities, users);
        verify(userRepository).findAll();
    }

    @Test
    void shouldUpdateUser() {

        UserServiceInterface userServiceInterface = new UserService(userRepository);

        UserEntity userEntity = new UserEntity(1, "name", "email", 5, 5, 5, "username", "pass");

        RegisterDto userEntityUpdate = new RegisterDto("usernameUpdate", "passUpdate", "nameUpdate", "emailUpdate", 10, 10, 10);

        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));

        UserEntity userUpdated = userServiceInterface.updateUser(userEntity.getId(), userEntityUpdate);
        assertEquals(userEntityUpdate.getName(), userUpdated.getName());
        verify(userRepository).findById(userEntity.getId());


    }

    @Test
    void shouldDeleteUser() {
        int id = 1;

        UserServiceInterface userServiceInterface = new UserService(userRepository);

        UserEntity userEntity = new UserEntity(1, "name", "email", 5, 5, 5, "username", "pass");


        when(userRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));
        ResponseEntity<String> resultResponse = userServiceInterface.deleteUser(userEntity.getId());

        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
        verify(userRepository).deleteById(userEntity.getId());

    }


//    @Test
//    void testDobandaMica() {
//
//        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
//        int result = operatiiDobanda.calculDobanda(TipDobanda.MICA);
//        int expectedResult = 0;
//
//        assertTrue(result == expectedResult);
//
//
//    }
//
//    @Test
//    void testDobandaCuRisc() {
//
//        User user = new User("Ana", TipRisc.RIDICAT);
//        when(dbOperation.getUser()).thenReturn(user);
//
//        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
//
//        int result = operatiiDobanda.calculDobandaCuRisc();
//        int expectedResult = 0;
//
//        assertTrue(result == expectedResult);
//
//        verify(dbOperation).getUser();
//
//
//    }


}