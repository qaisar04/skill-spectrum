package kz.baltabayev.developerservice.service;

import kz.baltabayev.developerservice.model.dto.DeveloperInfoResponse;
import kz.baltabayev.developerservice.model.entity.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeveloperService {

    DeveloperInfoResponse getInfo(Long id);

    void delete(Long id);

    Developer get(Long id);

    Developer save(Developer dev);

    Developer update(Developer dev);

    List<Developer> getAll();
}