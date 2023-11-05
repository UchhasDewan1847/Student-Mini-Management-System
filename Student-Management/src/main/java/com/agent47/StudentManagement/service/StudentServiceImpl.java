package com.agent47.StudentManagement.service;

import com.agent47.StudentManagement.entity.DuplicateFirstNameException;
import com.agent47.StudentManagement.entity.Student;
import com.agent47.StudentManagement.model.AddUpdateStudentModel;
import com.agent47.StudentManagement.model.NameAndAge;
import com.agent47.StudentManagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.UnsatisfiedRequestParameterException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    @Transactional(rollbackOn = Exception.class)
    public NameAndAge saveStudent(AddUpdateStudentModel addUpdateStudentModel) {
        Student newStudent = new Student();
        Student existingStudent = studentRepository.findByFirstNameContainingIgnoreCase(addUpdateStudentModel.getFirstName()).orElse(null);
        if(existingStudent!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Same first name not allowed");
        }
        newStudent.setFirstName(addUpdateStudentModel.getFirstName());
        newStudent.setLastName(addUpdateStudentModel.getLastName());
        newStudent.setQualification(addUpdateStudentModel.getQualification());
        if (addUpdateStudentModel.getAge()<18){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Age can not be less than 18");
        }
        newStudent.setAge(addUpdateStudentModel.getAge());
        studentRepository.save(newStudent);

        return new NameAndAge(addUpdateStudentModel.getFirstName(), addUpdateStudentModel.getAge());
    }

    @Override
    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateById(Student student) {
        Student student1 = studentRepository.findById(student.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found anything with this id : "+student.getId()));
        if(Objects.nonNull(student.getFirstName())&&!"".equalsIgnoreCase(student.getFirstName())){
            student1.setFirstName(student.getFirstName());
        }
        if(Objects.nonNull(student.getLastName())&&!"".equalsIgnoreCase(student.getLastName())){
            student1.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getAge())&&student.getAge()!=0){
            student1.setAge(student.getAge());
        }
        if(Objects.nonNull(student.getQualification())&&!"".equalsIgnoreCase(student.getQualification())){
            student1.setQualification(student.getQualification());
        }
        return studentRepository.save(student1);

    }

    @Override
    public Student removeById(Long id) {
        Student student = studentRepository.getReferenceById(id);
        studentRepository.deleteById(id);
        return student;
    }

    @Override
    public String removeByName(String firstName){
        Student student = studentRepository.findByFirstNameContainingIgnoreCase(firstName)
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found anything with this name : " + firstName));
        studentRepository.delete(student);
        return "Successful Deletion";
    }
}
