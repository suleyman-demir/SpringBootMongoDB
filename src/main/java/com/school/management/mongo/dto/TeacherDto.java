package com.school.management.mongo.dto;



import com.school.management.mongo.model.TeacherEntity;

import java.util.Collections;
import java.util.List;

public record TeacherDto(
        String id,
        String name,
        List<String> lessonNames



) {
        public static TeacherDto convert (TeacherEntity from){
            return new TeacherDto(from.getId(), from.getTeacherName(), Collections.singletonList(from.getTeacherLessonsName().toString()));
        }

        public static TeacherEntity convert (TeacherDto from){
            return new
                    TeacherEntity(from.id(), from.name(),null);
        }
}
