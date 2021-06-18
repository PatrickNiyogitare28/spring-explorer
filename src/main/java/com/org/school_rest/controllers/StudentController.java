package com.org.school_rest.controllers;

import com.org.school_rest.dto.SchoolManResponseDto;
import com.org.school_rest.dto.StudentDto;
import com.org.school_rest.models.Student;
import com.org.school_rest.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/school_management/v1/student")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(Student.class);
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/addStudent")
    public ResponseEntity<SchoolManResponseDto> createStudent(@Valid @RequestBody StudentDto studentDto)
            throws URISyntaxException {
        log.info("REST request to save studentDto : {}", studentDto);
        Student std = null;
        try {
            std = studentService.save(studentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
        }
        return ResponseEntity.ok()
                .body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSIFULLY RECORDED", new StudentDto(std)));
    }

}
