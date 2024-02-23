package kz.baltabayev.reviewerservice.model.entity;

import jakarta.persistence.*;
import kz.baltabayev.reviewerservice.model.types.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "reviewer_info")
@AllArgsConstructor
public class ReviewerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
