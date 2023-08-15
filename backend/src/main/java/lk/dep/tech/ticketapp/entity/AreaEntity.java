package lk.dep.tech.ticketapp.entity;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "areaDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "area",length = 150,nullable = false)
    private Area area;
    @Column(name = "totalAvailability",length = 100, nullable = false)
    private int availability;
    @Column(name = "recieved",length = 100, nullable = false)
    private int recieved;
    @OneToMany(mappedBy = "areaEntity")
    private Set<CheckInEntity> checkInEntities;

}
