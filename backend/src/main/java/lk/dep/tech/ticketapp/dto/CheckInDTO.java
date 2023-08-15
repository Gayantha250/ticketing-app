package lk.dep.tech.ticketapp.dto;

import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.entity.enums.Status;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckInDTO {
    private int id;
    private Category category;
    private Area area;
    private String regNumber;
    private String description;
    private String date;
    private String time;
    private Status status;
    private int area_id;
}
