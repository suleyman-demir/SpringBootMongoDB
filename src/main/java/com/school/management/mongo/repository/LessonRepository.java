package com.school.management.mongo.repository;

import com.school.management.mongo.model.LessonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository extends MongoRepository <LessonEntity,String> {
    void deleteById(String lessonId);

}
