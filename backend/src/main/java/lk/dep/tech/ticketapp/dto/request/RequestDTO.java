package lk.dep.tech.ticketapp.dto.request;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDTO {

    private Category category;
    private Area area;
    private String regNumber;
    private String description;
    private String date;
    private String time;
    private Status status;
    private int recieved;
}
