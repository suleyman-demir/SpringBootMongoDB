package com.school.management.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "teachers")
public class TeacherEntity {

    @Id
    private String teacherId;

    @Field("teacher_name")
    private String teacherName;

    @DBRef
    private List<LessonEntity> teacherLessonsName;

    public TeacherEntity(String teacherId, String teacherName, List<LessonEntity> teacherLessonsName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherLessonsName = teacherLessonsName;
    }

    public String getId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherLessonsName(List<LessonEntity> teacherLessonsName) {
        this.teacherLessonsName = teacherLessonsName;
    }
}
