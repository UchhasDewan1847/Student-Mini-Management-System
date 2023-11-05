package com.agent47.StudentManagement.service;

import com.agent47.StudentManagement.entity.Student;
import com.agent47.StudentManagement.model.AddUpdateStudentModel;
import com.agent47.StudentManagement.model.NameAndAge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    NameAndAge saveStudent(AddUpdateStudentModel addUpdateStudentModel);

    List<Student> saveStudents(List<Student> students);

    Student getStudentById(Long studentId);

    List<Student> getAll();

    Student updateById(Student student);

    Student removeById(Long id);

    String removeByName(String firstName);
}
