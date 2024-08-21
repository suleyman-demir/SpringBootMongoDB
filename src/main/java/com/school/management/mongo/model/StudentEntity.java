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
@Document(collection = "students")
public class StudentEntity {

    @Id
    private String studentId;

    @Field("student_name")
    private String studentName;

    @Field("student_number")
    private String studentNumber;

    @DBRef
    private List<NotesEntity> studentLessonNote;

    @DBRef
    private List<LessonEntity> studentLessonNames;

    public StudentEntity(String studentId, String studentName, String studentNumber, List<NotesEntity> studentLessonNote, List<LessonEntity> studentLessonNames) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentLessonNote = studentLessonNote;
        this.studentLessonNames = studentLessonNames;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<NotesEntity> getStudentLessonNote() {
        return studentLessonNote;
    }

    public void setStudentLessonNote(List<NotesEntity> studentLessonNote) {
        this.studentLessonNote = studentLessonNote;
    }

    public List<LessonEntity> getStudentLessonNames() {
        return studentLessonNames;
    }

    public void setStudentLessonNames(List<LessonEntity> studentLessonNames) {
        this.studentLessonNames = studentLessonNames;
    }
}
