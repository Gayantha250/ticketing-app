package lk.dep.tech.ticketapp.dto.response;

import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponsePaymentDTO {

    private String date;
    private Category category;
    private String regNumber;
    private String time;
    private String checkOutTime;
    public String hourly_rate;
    private String total_cost;

}
