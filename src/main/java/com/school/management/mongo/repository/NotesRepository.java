package com.school.management.mongo.repository;

import com.school.management.mongo.model.NotesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NotesRepository extends MongoRepository <NotesEntity, String> {

    Optional<NotesEntity> findByIdAndId(String studentId, String lessonId);
    Optional<NotesEntity> findById(String lessonId);
    void deleteById(String lessonId);
}
