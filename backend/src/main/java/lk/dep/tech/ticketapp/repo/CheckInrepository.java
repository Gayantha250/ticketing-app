package lk.dep.tech.ticketapp.repo;

import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.entity.AreaEntity;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.entity.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CheckInrepository extends JpaRepository<CheckInEntity,Integer> {
    List<CheckInEntity> findAllByIdEqualsOrDateEqualsOrTimeEqualsOrRegNumberEqualsOrCategoryEquals(int id, String date, String time, String regNumber, Category category);
    int countAllBy();
    List<CheckInEntity> findAllByAreaEntity(AreaEntity areaEntity); /// direct approach to the area_id co.lunmn
    boolean existsByAreaEntity(AreaEntity areaEntity);
}
