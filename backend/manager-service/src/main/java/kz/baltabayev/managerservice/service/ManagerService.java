package kz.baltabayev.managerservice.service;

import kz.baltabayev.managerservice.model.entity.Manager;
import kz.baltabayev.managerservice.model.entity.ManagerInfo;

import java.util.List;

public interface ManagerService {

    ManagerInfo getInfo(Long id);

    void delete(Long id);

    Manager get(Long id);

    Manager save(Manager manager);

    Manager update(Manager manager);

    List<Manager> getAll();

}

