package lk.dep.tech.ticketapp.service;

import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.entity.enums.Area;

public interface AreaService {
    String saveDetails(AreaDTO areaDTO);

    AreaDTO updateAreaDetails(AreaDTO areaDTO, Area area);

    String deleteArea(Area area);
}
