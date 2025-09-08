package edu.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "subject_name",length = 100, nullable = false,unique = true)
    private String subjectName;
    @Column(name = "status")
    private Boolean status;
}
