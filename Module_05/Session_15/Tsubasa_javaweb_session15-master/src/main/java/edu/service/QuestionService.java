package edu.service;

import edu.model.entity.Exam;
import edu.model.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByExamId(Long id);
    Question getQuestionById(Long id);
}
