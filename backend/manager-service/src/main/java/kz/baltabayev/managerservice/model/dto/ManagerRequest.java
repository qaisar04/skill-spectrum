package kz.baltabayev.managerservice.model.dto;

import kz.baltabayev.managerservice.model.types.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ManagerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Gender gender;
    private LocalDate birthDate;
}
