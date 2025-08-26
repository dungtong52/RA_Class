package edu.service;

import edu.model.dto.ServiceDTO;
import edu.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceService{
    List<Service> saveListAnimal();
    Page<Service> getListAnimals(Integer page, Integer size);
    Page<Service> getAnimalsByName(String name, Integer page, Integer size);
    List<ServiceDTO> top5AnimalWithServices();
}
