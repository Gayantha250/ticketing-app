package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.springframework.stereotype.Service;

@Service
public class CheckInServiceImpl implements CheckInService {


    @Override
    public String saveAll(CheckInDTO checkInDTO) {

        return "ok";
    }
}
