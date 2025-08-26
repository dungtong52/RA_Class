package edu.service;

import edu.model.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getExams();
    Exam insertExam(Exam exam);
    List<Exam> searchExamsByTitle(String title);
    Exam getExamById(Long id);
}
