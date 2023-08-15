package lk.dep.tech.ticketapp.dto.request;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestAreaDTO {

    private int id;
    private Area area;
    private int totalAvailability;
    private int recieved;

}
