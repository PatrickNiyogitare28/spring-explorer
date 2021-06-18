package com.org.school_rest.services.impl;

import com.org.school_rest.dto.StudentDto;
import com.org.school_rest.models.Student;
import com.org.school_rest.repositories.StudentRepository;
import com.org.school_rest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

//    @Autowired
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Student save(StudentDto dto) {
        return studentRepository.save(new Student(dto));
    }

    @Transactional
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public List<Student> getByFirstNameAndLastName(String firstName, String lastName) throws Exception {
        if(firstName == null || lastName == null)
             throw  new InvalidAttributesException("Firstname or Lastname should not be null");
        return studentRepository.findFirstNameAndLastNameHql(firstName,lastName);
    }
}
