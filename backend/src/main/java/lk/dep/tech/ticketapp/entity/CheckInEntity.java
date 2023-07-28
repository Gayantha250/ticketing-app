package lk.dep.tech.ticketapp.entity;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "check_in")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "category",length = 150,nullable = false)
    private Category category;
    @Enumerated(EnumType.STRING)
    @Column(name = "area",length = 150,nullable = false)
    private Area area;
    @Column(name = "reg_number",length = 200,nullable = false)
    private String regNumber;

    @Column(name="description",length = 250,nullable = false)
    private String description;

    @Column(name = "date")
    private String date;

}
