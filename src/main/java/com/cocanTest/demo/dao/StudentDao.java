package com.cocanTest.demo.dao;

import com.cocanTest.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    public List<Student>  findByEnableTrue();
    public Student findByEmailAndEnableTrue(String email);
    public Student findByNomAndEnableTrue(String nom);
    public Student findByIdEqualsAndEnableTrue(Integer id);


}
