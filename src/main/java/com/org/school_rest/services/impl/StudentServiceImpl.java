package com.org.school_rest.services.impl;

import com.org.school_rest.dto.StudentDto;
import com.org.school_rest.models.Student;
import com.org.school_rest.services.StudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    @Transactional
    public Student save(StudentDto dto) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
