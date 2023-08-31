package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.HourlyRateDTO;
import lk.dep.tech.ticketapp.dto.request.RequestHourlyRateDTO;
import lk.dep.tech.ticketapp.entity.enums.Category;

import java.util.List;

public interface HourlyRateService {
    String saveAllRates(RequestHourlyRateDTO requestHourlyRateDTO);

    List<HourlyRateDTO> getAllRates();

   String updateRates(RequestHourlyRateDTO requestHourlyRateDTO, int id);

    String deleteRate(int categoryId);

    HourlyRateDTO getRatesByCategory(Category category);

}
