package lk.dep.tech.ticketapp.dto;

import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeDifferenceDTO {
    private int id;
    private int checkInId;
    private String time;
    private  String outTime;

}
