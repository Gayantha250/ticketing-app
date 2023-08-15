package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.HourlyRateEntity;
import lk.dep.tech.ticketapp.entity.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HourlyRaterepository extends JpaRepository<HourlyRateEntity,Integer> {



}
