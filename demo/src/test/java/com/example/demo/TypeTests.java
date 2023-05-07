package com.example.demo;


import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.TypeDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.example.demo.interfaceService.TypeServiceInterface;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.TypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TypeTests {


    @Mock
    private TypeRepository typeRepository;

    @Mock
    private ExerciseRepository exerciseRepository;


    @Test
    public void shouldSaveType() {

        TypeServiceInterface typeServiceInterface = new TypeService(typeRepository, exerciseRepository);

        TypeDto typeDto = new TypeDto("name");


        when(typeRepository.save(any(TypeEntity.class))).thenReturn(new TypeEntity());


        TypeEntity typeEntityFromDto = new TypeEntity();
        BeanUtils.copyProperties(typeDto, typeEntityFromDto);

        ResponseEntity<String> resultResponse = typeServiceInterface.addType(typeDto);
        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
        verify(typeRepository).saveAndFlush(typeEntityFromDto);


    }

    @Test
    public void getAllTypes_success() {

        TypeServiceInterface typeServiceInterface = new TypeService(typeRepository, exerciseRepository);

        TypeEntity typeEntity = new TypeEntity("name1");
        TypeEntity typeEntity2 = new TypeEntity("name2");


        List<TypeEntity> types = new ArrayList<>(Arrays.asList(
                typeEntity, typeEntity2
        ));

        when(typeRepository.findAll()).thenReturn(types);

        List<TypeEntity> typeEntities = typeServiceInterface.getTypes();

        assertEquals(typeEntities, types);
        verify(typeRepository).findAll();
    }

    @Test
    void shouldUpdateType() {

        TypeServiceInterface typeServiceInterface = new TypeService(typeRepository, exerciseRepository);

        TypeEntity typeEntity = new TypeEntity(1, "name");

        TypeDto typeDtoUpdate = new TypeDto("nameUpdate");

        when(typeRepository.save(typeEntity)).thenReturn(typeEntity);
        when(typeRepository.findById(typeEntity.getId())).thenReturn(Optional.of(typeEntity));

        TypeEntity typeUpdated = typeServiceInterface.updateType(typeEntity.getId(), typeDtoUpdate);
        assertEquals(typeDtoUpdate.getName(), typeUpdated.getName());
        verify(typeRepository).findById(typeEntity.getId());


    }

    @Test
    void shouldDeleteType() {

        TypeServiceInterface typeServiceInterface = new TypeService(typeRepository, exerciseRepository);

        TypeEntity typeEntity = new TypeEntity(1, "name");


        when(typeRepository.findById(typeEntity.getId())).thenReturn(Optional.of(typeEntity));
        ResponseEntity<String> resultResponse = typeServiceInterface.deleteType(typeEntity.getId());

        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
        verify(typeRepository).deleteById(typeEntity.getId());

    }

}
