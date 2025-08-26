package edu.controller;

import edu.model.entity.Exam;
import edu.model.entity.Question;
import edu.service.ExamService;
import edu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/play")
public class PlayController {
    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService  questionService;

    @GetMapping("/exam/{examId}/questions")
    public String questions(@PathVariable Long examId, Model model){
        List<Question> questions = questionService.getQuestionsByExamId(examId);
        model.addAttribute("questions",questions);
        return "play/questions";
    }

    @GetMapping("/exam/{examId}")
    public String exam(@PathVariable("examId") Long examId, Model model) {
        Exam exam = examService.getExamById(examId);
        model.addAttribute("exam", exam);
        return "play/exam";
    }

    @GetMapping("/question/{questionId}/{examId}")
    public String  question(@PathVariable("questionId") Long questionId, @PathVariable("examId") Long examId,Model model) {
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question",question);
        model.addAttribute("examId",examId);
        return "play/question";
    }

    @PostMapping("/exam/question")
    public String checkQuestionOfExam(@ModelAttribute("question")Question question, Model model) {
        return "";
    }
}
