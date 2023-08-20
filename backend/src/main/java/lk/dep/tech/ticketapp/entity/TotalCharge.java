package lk.dep.tech.ticketapp.entity;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "total_charge")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TotalCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "category",length = 150,nullable = false)
    private Category category;
    @Column(name = "reg_number",length = 200,nullable = false)
    private String regNumber;
    @Column(name = "date",nullable = false)
    private String date;
    @Column(name = "time",nullable = false)
    private String time;
    @Column(name = "checkout_time",nullable = false)
    private String check_outTime;
    @Column(name = "hourly_rate",nullable = false,length = 150)
    public String hourly_rate;
    @Column(name = "total_cost",nullable = false,length = 150)
    private String total_cost;
}
