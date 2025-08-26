package edu.repo;

import edu.model.dto.ServiceDTO;
import edu.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findAllByNameContains(String name, Pageable pageable);

    //top 5 dong vat co nhieu dich vu nhat
    @Query("select s.animal.name, count(*) as totalService from Service s group by s.animal.id, s.animal.name order by count(*) desc limit 5")
    List<Object[]> top5AnimalWithServices();
}
