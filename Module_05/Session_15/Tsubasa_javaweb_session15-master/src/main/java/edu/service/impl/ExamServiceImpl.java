package edu.service.impl;

import edu.model.entity.Exam;
import edu.repo.ExamRepository;
import edu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Override
    public List<Exam> getExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam insertExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> searchExamsByTitle(String title) {
        return List.of();
    }

    @Override
    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khon ton tai exam "+id));
    }
}
