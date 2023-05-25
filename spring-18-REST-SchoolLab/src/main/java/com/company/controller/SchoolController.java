package com.company.controller;

import com.company.dto.AddressDTO;
import com.company.dto.ResponseWrapper;
import com.company.dto.TeacherDTO;
import com.company.service.AddressService;
import com.company.service.ParentService;
import com.company.service.StudentService;
import com.company.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeacher(){
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students successfully retrieved",studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper=new ResponseWrapper(true,"Parents retrieved successfully",
                HttpStatus.OK.value(), parentService.findAll());
        return ResponseEntity.ok(responseWrapper);
//        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper); //both acceptable
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {
        AddressDTO addressDTO =addressService.findById(id);
        return ResponseEntity.ok(new ResponseWrapper("Address retrieved successfully",addressDTO));
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id")Long id,@RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);

        return addressService.update(addressDTO);
    }


}
