package edu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "exam_marks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectMarkId;
    @Column(name = "exam_times")
    private Integer examTime;
    @Column(name = "exam_date")
    private Date examDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "mark")
    private Double mark;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;
}
