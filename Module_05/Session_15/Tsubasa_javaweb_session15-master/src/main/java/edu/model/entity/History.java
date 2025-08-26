package edu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "histories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", length = 100, nullable = false,unique = true)
    private String username;
    @Column(name = "correct_answer")
    private Integer correctAnswer;
    @Column(name = "wrong_answer")
    private Integer wrongAnswer;
    @Column(name = "complete")
    private Boolean complete;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
}
