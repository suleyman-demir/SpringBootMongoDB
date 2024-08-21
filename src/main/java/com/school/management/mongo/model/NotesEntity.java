package com.school.management.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class NotesEntity {

    @Id
    private String id;

    @Field("student_name")
    private String studentName;

    @Field("lesson_name")
    private String lessonName;

    private Integer note;

    @DBRef
    private StudentEntity student;

    @DBRef
    private LessonEntity lessons;

    public NotesEntity(String id, String studentName, String lessonName, StudentEntity student, LessonEntity lessons) {
        this.id = id;
        this.studentName = studentName;
        this.lessonName = lessonName;
        this.student = student;
        this.lessons = lessons;
    }

}