package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.HourlyRateDTO;
import lk.dep.tech.ticketapp.dto.request.RequestHourlyRateDTO;

import java.util.List;

public interface HourlyRateService {
    String saveAllRates(RequestHourlyRateDTO requestHourlyRateDTO);

    List<HourlyRateDTO> getAllRates();

    RequestHourlyRateDTO updateRates(HourlyRateDTO hourlyRateDTO, int id);

    String deleteRate(int categoryId);
}
