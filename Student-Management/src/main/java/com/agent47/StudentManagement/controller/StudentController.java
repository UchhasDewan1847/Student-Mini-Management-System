package com.agent47.StudentManagement.controller;

import com.agent47.StudentManagement.entity.Student;
import com.agent47.StudentManagement.model.AddUpdateStudentModel;
import com.agent47.StudentManagement.model.NameAndAge;
import com.agent47.StudentManagement.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/Student/save")
    public ResponseEntity<NameAndAge> saveStudent(@Valid @RequestBody AddUpdateStudentModel addUpdateStudentModel){
        return ResponseEntity.ok(studentService.saveStudent(addUpdateStudentModel));
    }
    @PostMapping("/Student/saves")
    public ResponseEntity<List<Student>> saveStudents(@Valid @RequestBody List<Student> students){
        return new ResponseEntity<>(studentService.saveStudents(students), HttpStatus.OK);
    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")Long studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId),HttpStatus.OK);
    }

    @GetMapping("/Student/all")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/Student/update")
    public ResponseEntity<Student> updateById(@Valid @RequestBody Student student){
        return new ResponseEntity<>(studentService.updateById(student),HttpStatus.OK);
    }

    @DeleteMapping("/Student/delete/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(studentService.removeById(id),HttpStatus.OK);
    }
    @DeleteMapping("/Student/delete/name/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable("name") String firstName){
        return new ResponseEntity<>(studentService.removeByName(firstName),HttpStatus.OK);
    }

}
