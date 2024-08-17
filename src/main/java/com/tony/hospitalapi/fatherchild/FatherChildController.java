package com.tony.hospitalapi.fatherchild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class FatherChildController {
    @Autowired
    FatherChildService fatherChildService;

    @PostMapping("create")
    public ResponseEntity<?> createFatherChild(
            @RequestBody FatherChildCreationDTO dto
    ){
        fatherChildService.createFatherChild(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully created");
    }


}
