package com.example.demo.services;

import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.TypeDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.example.demo.repository.TypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeEntity> getTypes() {
        return typeRepository.findAll();
    }


    /**
     * method that deletes a type resource
     * if the type deleted successfully it modifies the database otherwise
     * a message that the type does not exist
     */
    public void deleteType(Integer exerciseId) {
        boolean exists = typeRepository.existsById(exerciseId);
        if (!exists) {
            throw new IllegalStateException("type with id" + exerciseId + "does not exists");

        }
        typeRepository.deleteById(exerciseId);
    }


    /**
     * method that updates a type's fields
     * if the type is update successfully it modifies the database otherwise
     * if the name is already taken an error message will be shown
     * and the changes will not be made
     */
    @Transactional
    public void updateType(Integer typeId, TypeDto newType) {
        TypeEntity typeEntity = typeRepository.findById(typeId).orElseThrow(() -> new IllegalStateException("type with id " + typeId + " does not exist"));

        if (newType.getName() != null && newType.getName().length() > 0 && !Objects.equals(newType.getName(), typeEntity.getName())) {
            Optional<TypeEntity> typeOptional = typeRepository.findUserByName(newType.getName());

            if (typeOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            typeEntity.setName(newType.getName());
        }

        typeRepository.saveAndFlush(typeEntity);

    }


    /**
     * Method that adds a new type in the application
     * if the type is added successfully it returns status 200 OK otherwise
     * if the name is taken an error message will be shown and
     * the action will not succeed
     *
     * @param typeDto
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> addType(TypeDto typeDto) {
        Optional<TypeEntity> typeOptionalName = typeRepository.findUserByName(typeDto.getName());
        if (typeOptionalName.isPresent()) {
            throw new IllegalStateException("name taken");
        }


        TypeEntity typeEntity = new TypeEntity(typeDto.getName());


        typeRepository.saveAndFlush(typeEntity);

        return new ResponseEntity<>("Type added successfully!", HttpStatus.OK);
    }

}
