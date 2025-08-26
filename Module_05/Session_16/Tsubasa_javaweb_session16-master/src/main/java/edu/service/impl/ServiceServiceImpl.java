package edu.service.impl;

import edu.model.dto.ServiceDTO;
import edu.model.entity.Animal;
import edu.model.entity.Service;
import edu.repo.ServiceRepository;
import edu.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> saveListAnimal(){
        List<Service> list = new ArrayList<Service>();
        for(int i=1;i<=100;i++){
            Service s = new Service();
            s.setDescription("description"+i);
            s.setName("name"+i);
            s.setDuration(i);
            s.setPrice(Double.parseDouble(String.valueOf(i)));
            s.setImage("Image "+i);
            Animal a = new Animal();
            a.setId(1L);
            s.setAnimal(a);
            list.add(s);
        }
        return serviceRepository.saveAll(list);
    }

    @Override
    public Page<Service> getListAnimals(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> getAnimalsByName(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceRepository.findAllByNameContains(name,pageable);
    }

    @Override
    public List<ServiceDTO> top5AnimalWithServices() {
        List<Object[]> objects = serviceRepository.top5AnimalWithServices();
        List<ServiceDTO> listDTO = new ArrayList<>();
        for(Object[] ob : objects){
            ServiceDTO s = new ServiceDTO();
            s.setName(ob[0].toString());
            s.setTotalService(Long.parseLong(ob[1].toString()));
            listDTO.add(s);
        }
        return listDTO;
    }
}
