package kz.baltabayev.managerservice.service.impl;

import kz.baltabayev.managerservice.exception.ManagerNotFoundException;
import kz.baltabayev.managerservice.model.entity.Manager;
import kz.baltabayev.managerservice.model.entity.ManagerInfo;
import kz.baltabayev.managerservice.repository.ManagerRepository;
import kz.baltabayev.managerservice.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public ManagerInfo getInfo(Long id) {
        return get(id).getManagerInfo();
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager get(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException(id));
    }

    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }
}
