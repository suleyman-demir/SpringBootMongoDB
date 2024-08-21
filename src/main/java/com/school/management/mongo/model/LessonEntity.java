package com.school.management.mongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "lessons")
public class LessonEntity {

    @Id
    private String id;

    @Field("lesson_name")
    private String lessonName;

    @DBRef
    private TeacherEntity teacher;

    @DBRef
    private List<StudentEntity> student = new ArrayList<>();

    private List<NotesEntity> lessonNotes = new ArrayList<>();

    public LessonEntity(String id, String lessonName, TeacherEntity teacher, List<StudentEntity> student, List<NotesEntity> lessonNotes) {
        this.id = id;
        this.lessonName = lessonName;
        this.teacher = teacher;
        this.student = student;
        this.lessonNotes = lessonNotes;
    }

    public LessonEntity(String id, String lessonName, Object o) {
        this.id = id;
        this.lessonName = lessonName;
        this.teacher = (TeacherEntity) o;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public List<StudentEntity> getStudent() {
        return student;
    }

    public void setStudent(List<StudentEntity> student) {
        this.student = student;
    }

    public List<NotesEntity> getLessonNotes() {
        return lessonNotes;
    }

    public void setLessonNotes(List<NotesEntity> lessonNotes) {
        this.lessonNotes = lessonNotes;
    }
}
