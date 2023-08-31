package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.HourlyRateDTO;
import lk.dep.tech.ticketapp.dto.request.RequestHourlyRateDTO;
import lk.dep.tech.ticketapp.entity.HourlyRateEntity;
import lk.dep.tech.ticketapp.entity.enums.Category;
import lk.dep.tech.ticketapp.exception.DuplicateEntryException;
import lk.dep.tech.ticketapp.exception.NotFoundException;
import lk.dep.tech.ticketapp.repo.HourlyRaterepository;
import lk.dep.tech.ticketapp.service.HourlyRateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourlyRateServiceImpl implements HourlyRateService {
    @Autowired
    HourlyRaterepository hourlyRaterepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveAllRates(RequestHourlyRateDTO requestHourlyRateDTO) {
        HourlyRateEntity rateEntity = modelMapper.map(requestHourlyRateDTO, HourlyRateEntity.class);
        List<HourlyRateEntity> allHourlyRateEntity = hourlyRaterepository.findAll();
        for (HourlyRateEntity hourlyRateEntity : allHourlyRateEntity) {
            if (hourlyRateEntity.getCategory().equals(rateEntity.getCategory())) {
                throw new DuplicateEntryException("The Category is already exist");
            }
        }
        hourlyRaterepository.save(rateEntity);
        return "Successfully saved";
    }
    @Override
    public List<HourlyRateDTO> getAllRates() {
        List<HourlyRateEntity> allEntities = hourlyRaterepository.findAll();
        List<HourlyRateDTO> hourlyRateDTOS = modelMapper.map(allEntities, new TypeToken<List<HourlyRateDTO>>() {
        }.getType());
        return hourlyRateDTOS;
    }

    @Override
    public String updateRates(RequestHourlyRateDTO requestHourlyRateDTO, int id) {

        if(hourlyRaterepository.existsById(id)){
            HourlyRateEntity referenceIdEntity = hourlyRaterepository.getReferenceById(id);
            if( referenceIdEntity.getCategory().equals(requestHourlyRateDTO.getCategory())){
                modelMapper.map(requestHourlyRateDTO,referenceIdEntity);
                hourlyRaterepository.save(referenceIdEntity);
                return "successFully Updated";
            }else {
             throw  new DuplicateEntryException("Can not Change the Category type");
            }
        }else {
            throw new NotFoundException("id is not found");
        }
    }
    @Override
    public String deleteRate(int categoryId) {
        if(hourlyRaterepository.existsById(categoryId)){
            HourlyRateEntity referenceByIdEntity = hourlyRaterepository.getReferenceById(categoryId);
            hourlyRaterepository.delete(referenceByIdEntity);
            return "successfully deleted";
        }else {
            throw new NotFoundException("Id is not exist");
        }
    }
    @Override
    public HourlyRateDTO getRatesByCategory(Category category) {
      HourlyRateEntity hourlyRateEntity= hourlyRaterepository.getByCategory(category);
      if(hourlyRateEntity!=null){
          HourlyRateDTO map = modelMapper.map(hourlyRateEntity, HourlyRateDTO.class);
          return map;
      }else {
          throw new NotFoundException("Category is Not Exist");
      }
    }
}
