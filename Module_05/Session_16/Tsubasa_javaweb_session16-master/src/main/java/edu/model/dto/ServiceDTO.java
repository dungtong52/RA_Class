package edu.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ServiceDTO {
    private String name;
    private Long totalService;
}
