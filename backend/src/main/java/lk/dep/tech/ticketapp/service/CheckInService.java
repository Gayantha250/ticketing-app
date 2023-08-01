package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;

import java.util.List;

public interface CheckInService {
    String saveAll(RequestDTO requestDTO);


    List<CheckInDTO> getAllVehicles();

    String deleteVehicle(int vehicleId);

    CheckInDTO updateVehicle(RequestDTO requestDTO, int vehicleId);


    CheckInDTO getVehicleById(int vehicleId);
}
