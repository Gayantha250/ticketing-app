package lk.dep.tech.ticketapp.entity;

import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hourly_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HourlyRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category",length = 150,nullable = false)
    private Category category;
    @Column(name = "hourly_rate",nullable = false,length = 150)
    public String hourly_rate;

}
