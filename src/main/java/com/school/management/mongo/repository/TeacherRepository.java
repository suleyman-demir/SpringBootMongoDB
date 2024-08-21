package com.school.management.mongo.repository;

import com.school.management.mongo.model.TeacherEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository <TeacherEntity,String> {
    Optional<TeacherEntity> findByTeacherId(String teacherId);
    void deleteByTeacherId(String teacherId);
}
