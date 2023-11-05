package com.agent47.StudentManagement.repository;

import com.agent47.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {

//    @Query(value = "select * from student_info where first_name = :firstname", nativeQuery = true)
//    public Student findByFirstName(@Param("firstname") String firstname);

    void deleteByFirstName(String firstName);

    Optional<Student> findByFirstNameContainingIgnoreCase(String firstName);
}
