package lk.dep.tech.ticketapp.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckInDTO {
    private int id;
    private Category category;
    private Area area;
    private String regNumber;
    private String description;
    private String date;
    private String time;

    private Status status;

}
