package kz.baltabayev.developerservice.model.dto;

import kz.baltabayev.developerservice.model.payload.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperInfoResponse {
    DeveloperRequest developerRequest;
    private List<Task> tasks;
    //todo по возможности ачивки
}
