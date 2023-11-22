package com.cocanTest.demo.logic;

import com.cocanTest.demo.dto.StudentDto;
import com.cocanTest.demo.entities.Student;

import java.util.List;

public interface StudentLogic extends Crud<Student> {

    public List<Student> getAllStudents();

    public Student getStudentsById();

    public Student addStudent(StudentDto student);

    public Student updateStudent(Integer id ,StudentDto student);


    void deleteStudent(Integer id);
}
