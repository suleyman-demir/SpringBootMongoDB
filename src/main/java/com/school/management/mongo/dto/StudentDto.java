
package com.school.management.mongo.dto;

import com.school.management.mongo.model.StudentEntity;
import com.school.management.mongo.model.LessonEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record StudentDto(
        String studentId,
        String name,
        String number,
        List<NotesDto> notes,
        List<String> studentLessonNames
) {
    public static StudentDto convert(StudentEntity from) {
        return new StudentDto(
                from.getStudentId(),
                from.getStudentName(),
                from.getStudentNumber(),
                Optional.ofNullable(from.getStudentLessonNote())
                        .map(notes -> notes.stream()
                                .map(note -> new NotesDto(note.getLessonName(), note.getNote()))
                                .toList())
                        .orElse(Collections.emptyList()),
                Optional.ofNullable(from.getStudentLessonNames())
                        .map(lessons -> lessons.stream()
                                .map(LessonEntity::getLessonName)
                                .toList())
                        .orElse(Collections.emptyList())
        );
    }

    public static StudentEntity convert(StudentDto from) {
        return new StudentEntity(
                from.studentId(),
                from.name(),
                from.number(),
                null,
                null
        );
    }
}
