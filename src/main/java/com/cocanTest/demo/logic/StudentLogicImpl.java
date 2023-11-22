package com.cocanTest.demo.logic;

import com.cocanTest.demo.dao.StudentDao;
import com.cocanTest.demo.dto.StudentDto;
import com.cocanTest.demo.entities.Student;
import com.cocanTest.demo.exceptions.ResourceAlreadyExistsException;
import com.cocanTest.demo.tools.DateTools;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class StudentLogicImpl implements StudentLogic {

    private final StudentDao studentDao;
    private final ModelMapper modelMapper;

    private final DateTools dateTools;

    public StudentLogicImpl(StudentDao studentDao, ModelMapper modelMapper, DateTools dateTools) {
        this.studentDao = studentDao;
        this.modelMapper = modelMapper;
        this.dateTools = dateTools;
    }



    @Override
    public Student getStudentsById() {
        return null;
    }

    @Override
    public Student save(Student entity) {
        return studentDao.save(entity);
    }

    @Override
    public Student update(Student entity) {
        return studentDao.save(entity);
    }

    @Override
    public Student getById(Integer id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findByEnableTrue();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Student> getAllStudents() {
        try{
            return this.getAll();
        }catch (Exception  e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Student addStudent(StudentDto studentrequest) {
        Student studentByEmail = studentDao.findByEmailAndEnableTrue(studentrequest.getEmail());

        if(Objects.isNull(studentByEmail)){
            Student student = modelMapper.map(studentrequest, Student.class);
            student.setEnable(true);
            student.setDatecreation(dateTools.getCurrentDateInTimestamp());
            student.setPhoto("http://www.kyrmann.com/wp-content/uploads/2018/05/image001.png");
            log.info("Info", student);
            return this.save(student);
        }
        return null;
    }

    @Override
    public Student updateStudent(Integer id, StudentDto studentrequest) {
        Student studentById = studentDao.findByIdEqualsAndEnableTrue(id);

        if (Objects.nonNull(studentById)){
            Student studentDto = modelMapper.map(studentrequest, Student.class);
            if(studentDto.getMotdepasse()!=null) studentById.setMotdepasse(studentDto.getMotdepasse());
            if(studentDto.getContact()!=null) studentById.setContact(studentDto.getContact());
            if(studentDto.getPrenoms()!=null) studentById.setPrenoms(studentDto.getPrenoms());
            if(studentDto.getNom()!=null) studentById.setNom(studentDto.getNom());
            if(studentDto.getEmail()!=null) {
                Student studentbyemail = studentDao.findByEmailAndEnableTrue(studentDto.getEmail());
                if(Objects.nonNull(studentbyemail) && studentbyemail.getId().equals(id)){
                    studentById.setEmail(studentDto.getEmail());
                }else {
                    log.info("Cet email existe déja dans la base de donnée");
                }
            }
            return this.update(studentById);
        }

        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Student studentById = studentDao.findByIdEqualsAndEnableTrue(id);
        if (Objects.nonNull(studentById)){
            studentById.setEnable(false);
            this.update(studentById);
        }


    }



}
