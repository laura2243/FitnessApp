package com.example.demo.interfaceService;

import com.example.demo.dto.TypeDto;
import com.example.demo.entity.TypeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeServiceInterface {

    List<TypeEntity> getTypes();

    ResponseEntity<String> deleteType(Integer typeId);


    TypeEntity updateType(Integer typeId, TypeDto newType);

    ResponseEntity<String> addType(TypeDto typeDto);
}
