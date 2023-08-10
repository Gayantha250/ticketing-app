package lk.dep.tech.ticketapp.dto;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {

    private Area area;
    private int totalAvailability;

}
