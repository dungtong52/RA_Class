package edu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "answerA",nullable = false)
    private String answerA;
    @Column(name = "answerB",nullable = false)
    private String answerB;
    @Column(name = "answerC",nullable = false)
    private String answerC;
    @Column(name = "answerD",nullable = false)
    private String answerD;
    @Column(name = "answerTrue",nullable = false)
    private String answerTrue;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
}
