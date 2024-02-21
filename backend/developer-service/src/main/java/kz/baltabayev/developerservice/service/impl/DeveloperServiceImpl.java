package kz.baltabayev.developerservice.service.impl;

import kz.baltabayev.developerservice.exception.DeveloperNotFoundException;
import kz.baltabayev.developerservice.mapper.DeveloperMapper;
import kz.baltabayev.developerservice.model.dto.DeveloperInfoResponse;
import kz.baltabayev.developerservice.model.dto.DeveloperRequest;
import kz.baltabayev.developerservice.model.entity.Developer;
import kz.baltabayev.developerservice.repository.DeveloperRepository;
import kz.baltabayev.developerservice.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public DeveloperInfoResponse getInfo(Long id) {
        Developer developer = get(id);
        DeveloperRequest developerRequest = developerMapper.toDto(developer);
        return new DeveloperInfoResponse(); //todo
    }

    @Override
    public void delete(Long id) {
        developerRepository.deleteById(id);
    }

    @Override
    public Developer get(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException(id));
    }

    @Override
    public Developer save(Developer dev) {
        return developerRepository.save(dev);
    }

    @Override
    public Developer update(Developer dev) {
        return developerRepository.save(dev);
    }

    @Override
    public List<Developer> getAll() {
        return developerRepository.findAll();
    }
}
