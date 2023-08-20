package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.TotalCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TotalChargeRepo extends JpaRepository<TotalCharge,Integer> {


}
