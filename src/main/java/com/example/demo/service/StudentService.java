package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.StudentRequestEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<StudentEntity> findById(int id){
        return studentRepository.findById(id);
    }

    public Optional<StudentEntity> findOne(int id){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        return studentRepository.findOne(Example.of(studentEntity));
    }

    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }

    public StudentEntity save(StudentRequestEntity studentRequestEntity){
        StudentEntity studentEntity = Optional.of(studentRequestEntity).map(StudentEntity::new).get();
        return studentRepository.save(studentEntity);
    }

    public StudentEntity save(String name, int id){
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if(optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            studentEntity.setName(name);
            return studentRepository.save(studentEntity);
        }
        return null;
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }
}