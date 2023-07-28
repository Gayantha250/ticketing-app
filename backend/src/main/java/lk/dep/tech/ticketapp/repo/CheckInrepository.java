package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInrepository extends JpaRepository<CheckInEntity,Integer> {


}
