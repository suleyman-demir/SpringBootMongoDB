package com.school.management.mongo.service;


import com.school.management.mongo.dto.StudentDto;
import com.school.management.mongo.exception.ResourceNotFoundException;
import com.school.management.mongo.model.StudentEntity;
import com.school.management.mongo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentDto studentDto) {
        logger.info("Öğrenci ekleniyor: {}", studentDto.name());
        StudentEntity studentEntity = StudentDto.convert(studentDto);
        studentRepository.save(studentEntity);
        logger.info("Öğrenci başarıyla eklendi: {}", studentEntity.getStudentId());
    }

    public void addStudents(List<StudentDto> studentDtos) {
        logger.info("{} öğrenci ekleniyor.", studentDtos.size());
        List<StudentEntity> studentEntities = studentDtos.stream()
                .map(StudentDto::convert)
                .collect(Collectors.toList());
        studentRepository.saveAll(studentEntities);
        logger.info("Tüm öğrenciler başarıyla eklendi.");
    }

    public StudentDto getStudentByStudentId(String studentId) {
        logger.info("ID'si {} olan öğrenci getiriliyor.", studentId);
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Bu ID'ye sahip öğrenci bulunamadı: " + studentId));
        return StudentDto.convert(studentEntity);
    }

    public Optional<StudentEntity> getStudentEntityById(String studentId) {
        logger.info("Fetching student with ID: {}", studentId);
        return studentRepository.findByStudentId(studentId);
    }

    public void updateStudentByStudentId(String studentId, StudentDto studentDto) {
        logger.info("ID'si {} olan öğrenci güncelleniyor.", studentId);
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Bu ID'ye sahip öğrenci bulunamadı: " + studentId));
        studentEntity.setStudentName(studentDto.name());
        studentEntity.setStudentNumber(studentDto.number());
        studentRepository.save(studentEntity);
        logger.info("Öğrenci başarıyla güncellendi: {}", studentEntity.getStudentId());
    }

    public void deleteStudentByStudentId(String studentId) {
        logger.info("ID'si {} olan öğrenci siliniyor.", studentId);
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Bu ID'ye sahip öğrenci bulunamadı: " + studentId));
        studentRepository.delete(studentEntity);
        logger.info("Öğrenci başarıyla silindi: {}", studentId);
    }

    public List<StudentDto> getAllStudents() {
        logger.info("Tüm öğrenciler getiriliyor.");
        return studentRepository.findAll().stream()
                .map(StudentDto::convert)
                .collect(Collectors.toList());
    }
}
