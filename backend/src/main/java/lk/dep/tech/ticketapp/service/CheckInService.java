package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.paginated.PaginatedResponseDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.entity.TotalCharge;
import lk.dep.tech.ticketapp.entity.enums.Category;

import java.util.List;

public interface CheckInService {
    String saveAll(RequestDTO requestDTO);

    String deleteVehicle(int vehicleId);

    CheckInDTO updateVehicle(RequestDTO requestDTO, int vehicleId);
    List<RequestDTO> getVehicleBySearch(int id, String date, String time, String regNumber, Category category);

   PaginatedResponseDTO getAllVehiclesByPaginated(int page, int size);

    CheckInDTO getDetailsById(int parkingId);
}
