package edu.repo;

import edu.model.entity.Exam;
import edu.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Exam> findAllByExam_Id(Long examId);

    List<Question> findQuestionsByExam_Id(Long examId);
}
