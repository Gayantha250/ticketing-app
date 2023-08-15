package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.paginated.PaginatedResponseDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseDTO;
import lk.dep.tech.ticketapp.entity.AreaEntity;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.exception.NotFoundException;
import lk.dep.tech.ticketapp.repo.AreaRepository;
import lk.dep.tech.ticketapp.repo.CheckInrepository;
import lk.dep.tech.ticketapp.service.AreaService;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CheckInrepository checkInrepository;

    @Autowired
    AreaRepository areaRepository;

    @Override
    @Transactional
    public String saveAll(RequestDTO requestDTO) {
        AreaEntity areaEntity = areaRepository.findByAreaEquals(requestDTO.getArea());
      if(areaEntity!=null){
          CheckInEntity checkInEntity = modelMapper.map(requestDTO, CheckInEntity.class);
          checkInEntity.setAreaEntity(areaEntity);
          checkInrepository.save(checkInEntity);

          if(checkInrepository.existsByAreaEntity(areaEntity)){
              List<CheckInEntity> chekEntityList = checkInrepository.findAllByAreaEntity(areaEntity);
              if(chekEntityList.size()>0){
                  areaEntity.setRecieved(chekEntityList.size());
              }else {
                  areaEntity.setRecieved(0);
              }
          }else {
              throw new NotFoundException("No area Availabilty");
          }
          }

        return "Data is saved";
    }


    @Override
    public String deleteVehicle(int vehicleId) {
        if(checkInrepository.existsById(vehicleId)){
            checkInrepository.deleteById(vehicleId);
            return vehicleId+ " is deleted";
        }else {
            throw new NotFoundException("id is not exist");
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
            throw new NotFoundException("There is no that id");
        }
    }

    @Override
    public List<RequestDTO> getVehicleBySearch(int id, String date, String time, String regNumber, Category category) {
        List<CheckInEntity> checkInEntity = checkInrepository.findAllByIdEqualsOrDateEqualsOrTimeEqualsOrRegNumberEqualsOrCategoryEquals(id, date, time, regNumber, category);
        List<RequestDTO> requestDTO = modelMapper.map(checkInEntity, new TypeToken<List<RequestDTO>>() {
        }.getType());
        return requestDTO;
    }

    @Override
    public PaginatedResponseDTO getAllVehiclesByPaginated(int page, int size) {
        Page<CheckInEntity> all = checkInrepository.findAll(PageRequest.of(page, size));
        int number = checkInrepository.countAllBy();
        if(all.getSize()<1){
            throw  new NotFoundException("No data to retriew");
        }else {
            List<ResponseDTO> list = all.stream()
                    .map(checkInEntity -> modelMapper.map(checkInEntity, ResponseDTO.class))
                    .collect(Collectors.toList());

            PaginatedResponseDTO pgrDTO = new PaginatedResponseDTO(list, number );
            return pgrDTO;
        }
    }


}
