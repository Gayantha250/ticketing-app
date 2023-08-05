package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.HourlyRateEntity;
import lk.dep.tech.ticketapp.entity.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourlyRaterepository extends JpaRepository<HourlyRateEntity,Integer> {



}
