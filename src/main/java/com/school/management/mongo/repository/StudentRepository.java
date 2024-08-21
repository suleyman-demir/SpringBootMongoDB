package com.school.management.mongo.repository;

import com.school.management.mongo.model.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<StudentEntity,String> {

    Optional<StudentEntity> findByStudentId(String studentId);
    void deleteByStudentId(String studentId);
    Optional<StudentEntity> getStudentByStudentId(String studentId);
    Optional<StudentEntity> findById(String lessonId);


}
