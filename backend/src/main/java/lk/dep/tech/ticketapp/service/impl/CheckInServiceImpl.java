package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.repo.CheckInrepository;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                checkInDTO.getDate(),
                checkInDTO.getTime(),
                checkInDTO.getStatus()
        );

        checkInrepository.save(checkInEntity);
        return "Data is saved";
    }

    @Override
    public List <CheckInDTO> getAllVehicles() {
      List<CheckInDTO> list= new ArrayList<>();
        List<CheckInEntity> allCheckEntities = checkInrepository.findAll();
        for (CheckInEntity allCheckEntity : allCheckEntities) {
            CheckInDTO checkInDTO = new CheckInDTO(
                    allCheckEntity.getId(),
                    allCheckEntity.getCategory(),
                    allCheckEntity.getArea(),
                    allCheckEntity.getRegNumber(),
                    allCheckEntity.getDescription(),
                    allCheckEntity.getDate(),
                    allCheckEntity.getTime(),
                    allCheckEntity.getStatus()
                    );
            list.add(checkInDTO);
        }
        return list;
    }
}
