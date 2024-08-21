package com.school.management.mongo.service;

import com.school.management.mongo.repository.LessonRepository;
import com.school.management.mongo.repository.NotesRepository;
import com.school.management.mongo.repository.StudentRepository;

import com.school.management.mongo.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final NotesRepository notesRepository;
    private final TeacherRepository teacherRepository;
    private static final Logger logger = LoggerFactory.getLogger(UniversityService.class);

    public UniversityService(StudentRepository studentRepository, LessonRepository lessonRepository, NotesRepository notesRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
        this.notesRepository = notesRepository;
        this.teacherRepository = teacherRepository;
    }


    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public LessonRepository getLessonRepository() {
        return lessonRepository;
    }

    public NotesRepository getNotesRepository() {
        return notesRepository;
    }

    public TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }
}
