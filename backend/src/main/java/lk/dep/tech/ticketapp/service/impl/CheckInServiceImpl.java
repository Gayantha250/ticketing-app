package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.repo.CheckInrepository;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CheckInrepository checkInrepository;

    @Override
    public String saveAll(RequestDTO requestDTO) {
        CheckInEntity checkInEntity = modelMapper.map(requestDTO, CheckInEntity.class);
        checkInrepository.save(checkInEntity);
        return "Data is saved";
    }
    @Override
    public List<CheckInDTO> getAllVehicles() {
        List<CheckInEntity> allCheckEntities = checkInrepository.findAll();
        List<CheckInDTO> checkInDTOS = modelMapper.map(allCheckEntities, new TypeToken<List<CheckInDTO>>() {
        }.getType());
        return checkInDTOS;

    }

    @Override
    public String deleteVehicle(int vehicleId) {
        if(checkInrepository.existsById(vehicleId)){
            checkInrepository.deleteById(vehicleId);
            return vehicleId+ " is deleted";
        }else {
            throw new RuntimeException("id is not exist");
        }
    }

    @Override
    public CheckInDTO updateVehicle(RequestDTO requestDTO, int vehicleId) {
        if(checkInrepository.existsById(vehicleId)){
            CheckInEntity entity = checkInrepository.getReferenceById(vehicleId);
            modelMapper.map(requestDTO,entity);
            CheckInEntity updateEntity = checkInrepository.save(entity);
            CheckInDTO updateDTO = modelMapper.map(updateEntity, CheckInDTO.class);
            return updateDTO;
        }else {
            throw new RuntimeException("There is no that id");
        }
    }

    @Override
    public List<RequestDTO> getVehicleBySearch(int id, String date, String time, String regNumber, String vehicleType) {
        CheckInEntity checkInEntity = checkInrepository.findAllByIdEqualsOrDateEqualsOrTimeEqualsOrRegNumberEqualsOrCategoryEquals(id, date, time, regNumber, vehicleType);
        List<RequestDTO> requestDTO = modelMapper.map(checkInEntity, new TypeToken<List<RequestDTO>>() {
        }.getType());
        return requestDTO;
    }


}
