package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.dto.request.RequestAreaDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseAreaDTO;
import lk.dep.tech.ticketapp.entity.enums.Area;

public interface AreaService {
    String saveDetails(AreaDTO areaDTO);

    ResponseAreaDTO updateAreaDetails(RequestAreaDTO requestAreaDTO,int id);

    String deleteArea(int id);
}
