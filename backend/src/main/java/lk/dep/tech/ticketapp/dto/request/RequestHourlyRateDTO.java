package lk.dep.tech.ticketapp.dto.request;

import lk.dep.tech.ticketapp.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestHourlyRateDTO {
    private Category category;
    public String hourly_rate;

}
