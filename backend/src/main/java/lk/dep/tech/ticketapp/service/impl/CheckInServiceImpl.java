package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.repo.CheckInrepository;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    CheckInrepository checkInrepository;
    @Override
    public String saveAll(CheckInDTO checkInDTO) {

        CheckInEntity  checkInEntity=new CheckInEntity(
                checkInDTO.getId(),
                checkInDTO.getCategory(),
                checkInDTO.getArea(),
                checkInDTO.getRegNumber(),
                checkInDTO.getDescription(),
                checkInDTO.getDate()
        );

        checkInrepository.save(checkInEntity);
        return "Data is saved";
    }
}
