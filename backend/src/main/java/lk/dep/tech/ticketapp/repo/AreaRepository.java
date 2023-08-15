package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.entity.AreaEntity;
import lk.dep.tech.ticketapp.entity.enums.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AreaRepository extends JpaRepository<AreaEntity,Integer> {
    AreaEntity findByAreaEquals(Area area);

    AreaEntity findAreaEntityByArea(Area area);


}
