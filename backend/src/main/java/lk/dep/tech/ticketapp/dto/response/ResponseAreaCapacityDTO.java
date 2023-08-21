package lk.dep.tech.ticketapp.dto.response;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseAreaCapacityDTO {

    private int id;
    private Area area;
    private int capacity;
}
