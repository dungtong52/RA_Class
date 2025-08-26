package edu.controller;

import edu.model.entity.Exam;
import edu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping
    public String listExams(Model model){
        List<Exam> exams = examService.getExams();
        model.addAttribute("exams",exams);
        return "exam/listExams";
    }

    @GetMapping("/add")
    public String add(Model model){
        Exam exam = new Exam();
        model.addAttribute("exam",exam);
        return  "exam/addExam";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("exam") Exam exam,Model model, RedirectAttributes redirectAttributes){
        Exam exam1 = examService.insertExam(exam);
        if(exam1!=null){
                redirectAttributes.addFlashAttribute("success","Insert successfully form exam "+exam1.getId());
                return  "redirect:/exams";
        }else{
            model.addAttribute("error","Insert failed!");
            return "exam/addExam";
        }
    }
}
