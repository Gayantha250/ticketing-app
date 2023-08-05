package lk.dep.tech.ticketapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "timeDifference")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeDifference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "vehicleId",referencedColumnName = "id")
    private CheckInEntity checkIn;
    @Column(name = "intime")
    private String time;

    @Column(name="check_out_time")
    private  String outTime;


}
