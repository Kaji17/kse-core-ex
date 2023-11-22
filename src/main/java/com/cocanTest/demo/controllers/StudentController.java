package com.cocanTest.demo.controllers;

import com.cocanTest.demo.dto.StudentDto;
import com.cocanTest.demo.entities.Student;
import com.cocanTest.demo.logic.StudentLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(value = "/api/student")
public class StudentController {

    @Autowired
    private StudentLogic studentLogic;
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentLogic.getAllStudents(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(studentLogic.getAllStudents(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        try{
            return new ResponseEntity<>(studentLogic.addStudent(studentDto), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(studentLogic.addStudent(studentDto), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value = "/updstudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto){
        try{
            Student studentresult=studentLogic.updateStudent(id,studentDto);
            return ResponseEntity.ok().body(studentresult);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(studentLogic.updateStudent(id, studentDto), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "deletestudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        try{
            studentLogic.deleteStudent(id);
            return ResponseEntity.ok().body(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().body(null);
    }
}
