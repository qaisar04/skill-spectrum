package kz.baltabayev.developerservice.model.entity;

import jakarta.persistence.*;
import kz.baltabayev.developerservice.model.types.Gender;
import kz.baltabayev.developerservice.model.types.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "developer_info")
@AllArgsConstructor
public class DeveloperInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
