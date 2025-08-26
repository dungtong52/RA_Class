package edu.controller;

import edu.model.dto.ServiceDTO;
import edu.model.entity.Service;
import edu.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/create-list-service")
    public String saveListAnimal(){
        serviceService.saveListAnimal();
        return "home";
    }

    @GetMapping
    public String listAnimals(@RequestParam(name = "page", defaultValue = "0")Integer page, Model model){
        Integer pageSize = 10;
        if(page!=0)
            page = page-1;

        Page<Service> pageService = serviceService.getListAnimals(page, pageSize);
        int totalPages = pageService.getTotalPages();
        List<Service> listServices = pageService.getContent();

        model.addAttribute("isSearch", false);
        model.addAttribute("listServices", listServices);
        model.addAttribute("page", page);

        List<Integer> listPage = new ArrayList<>();
        for(int i=1;i<=totalPages;i++){
            listPage.add(i);
        }
        model.addAttribute("listPage", listPage);

        return "listAnimal";
    }

    @GetMapping("/search")
    public String searchAnimals(@RequestParam(name = "page", defaultValue = "0")Integer page, @RequestParam("name")String name, Model model){
        Integer pageSize = 10;
        if(page!=0)
            page = page-1;

        Page<Service> pageService = serviceService.getAnimalsByName(name, page, pageSize);
        int totalPages = pageService.getTotalPages();
        List<Service> listServices = pageService.getContent();

        model.addAttribute("isSearch", true);
        model.addAttribute("name",name);

        model.addAttribute("listServices", listServices);
        model.addAttribute("page", page);

        List<Integer> listPage = new ArrayList<>();
        for(int i=1;i<=totalPages;i++){
            listPage.add(i);
        }
        model.addAttribute("listPage", listPage);

        return "listAnimal";
    }

    @GetMapping("/limit5-service-animal")
    public String limit5ServiceAnimal(Model model){
        List<ServiceDTO> listTop5 = serviceService.top5AnimalWithServices();
        model.addAttribute("list",listTop5);
        return "listTopo5Service";
    }
}
