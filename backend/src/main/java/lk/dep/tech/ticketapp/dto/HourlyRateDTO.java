package lk.dep.tech.ticketapp.dto;

import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourlyRateDTO {

    private int id;
    private Category category;
    public String hourly_rate;
}
