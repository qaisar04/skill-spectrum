package kz.baltabayev.developerservice.model.dto;

import kz.baltabayev.developerservice.model.types.Gender;
import kz.baltabayev.developerservice.model.types.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperRequest {
    private String email;
    private String firstname;
    private String lastname;
    private Position position;
    private Gender gender;
    private Double score;
    private LocalDate birthDate;
}
