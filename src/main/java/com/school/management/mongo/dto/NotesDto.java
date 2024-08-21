package com.school.management.mongo.dto;


import com.school.management.mongo.model.NotesEntity;

public record NotesDto(
        String id,
       String studentName,
       String lessonName,
       Integer note
) {
    public NotesDto(String lessonName, Integer note) {
        this(null, null, lessonName, note);
    }

    public static NotesDto convert(NotesEntity from){
        return new NotesDto(
                from.getId(),
                from.getStudentName(),
                from.getLessonName(),
                from.getNote()
        );
    }

    public static NotesEntity convert(NotesDto from){
        return new NotesEntity(
                from.id,
                from.studentName,
                from.lessonName,
                null,
                null
        );
    }

    public static void setId(String id) {

    }
}
