package edu.service.impl;

import edu.model.entity.Exam;
import edu.model.entity.Question;
import edu.repo.QuestionRepo;
import edu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;


    @Override
    public List<Question> getQuestionsByExamId(Long id) {
        return questionRepo.findQuestionsByExam_Id(id);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepo.findById(id).get();
    }
}
