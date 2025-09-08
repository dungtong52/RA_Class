package edu.repo;

import edu.model.entity.ExamMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMarkRepo extends JpaRepository<ExamMark,Integer> {
}
