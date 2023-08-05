package lk.dep.tech.ticketapp.dto.paginated;

import lk.dep.tech.ticketapp.dto.request.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseDTO {
    List<ResponseDTO> list;
    private int dataCount;
}
