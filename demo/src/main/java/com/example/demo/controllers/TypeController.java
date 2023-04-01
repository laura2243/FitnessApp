package com.example.demo.controllers;


import com.example.demo.dto.TypeDto;
import com.example.demo.entity.TypeEntity;
import com.example.demo.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class that is responsible for processing incoming REST API requests for
 * the interaction with types of exercises,
 * converts the JSON parameter to an exercise object, and it sends it to the service layer.
 */
@RestController
@RequestMapping(path = "api/type")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    /**
     * method that handles the api call for returning all types
     * it calls the method from the service package
     */
    @GetMapping
    public List<TypeEntity> getType() {
        return typeService.getTypes();
    }

    /**
     * method that handles the api call for deleting a type
     * it calls the method from the service package
     */
    @DeleteMapping(path = "{typeId}")
    public void deleteType(@PathVariable("typeId") Integer typeId) {
        typeService.deleteType(typeId);
    }


    /**
     * method that handles the api call for updating a type
     * it calls the method from the service package
     */
    @PutMapping(path = "{typeId}")
    public void updateType(@PathVariable("typeId") Integer typeId, @RequestBody TypeDto typeDto) {
        typeService.updateType(typeId, typeDto);
    }

    /**
     * method that handles the api call for adding a type
     * it calls the method from the service package
     */
    @PostMapping("addType")
    public ResponseEntity<String> addType(@RequestBody TypeDto typeDto) {

        return typeService.addType(typeDto);
    }
}
