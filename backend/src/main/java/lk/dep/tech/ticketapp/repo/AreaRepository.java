package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity,Enum> {


}
