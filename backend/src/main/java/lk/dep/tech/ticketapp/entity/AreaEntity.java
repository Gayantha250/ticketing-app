package lk.dep.tech.ticketapp.entity;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "area")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AreaEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "area",length = 150,nullable = false)
    private Area area;

    @Column(name = "availability",length = 100, nullable = false)
    private int availability;


}
