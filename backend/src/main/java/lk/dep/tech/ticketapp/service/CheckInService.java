package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.CheckInDTO;

import java.util.List;

public interface CheckInService {
    String saveAll(CheckInDTO checkInDTO);


    List<CheckInDTO> getAllVehicles();
}
