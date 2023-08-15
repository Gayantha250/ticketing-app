package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.dto.request.RequestAreaDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseAreaDTO;
import lk.dep.tech.ticketapp.entity.AreaEntity;
import lk.dep.tech.ticketapp.entity.CheckInEntity;
import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.exception.DuplicateEntryException;
import lk.dep.tech.ticketapp.exception.NotFoundException;
import lk.dep.tech.ticketapp.repo.AreaRepository;
import lk.dep.tech.ticketapp.repo.CheckInrepository;
import lk.dep.tech.ticketapp.service.AreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
   CheckInrepository checkInrepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveDetails(AreaDTO areaDTO) {
        AreaEntity areaEntity = modelMapper.map(areaDTO, AreaEntity.class);
        if(areaRepository.findAll().size()==0){
           areaRepository.save(areaEntity);
           return "Saved Succcessfullly";
        }else {
            AreaEntity areaEntityByArea = areaRepository.findAreaEntityByArea(areaDTO.getArea());
            if(areaEntityByArea!=null){
            throw new  DuplicateEntryException("The Area is already Exist");
            }
            areaRepository.save(areaEntity);
            return "successfully saved";
        }
    }
    @Override
    public ResponseAreaDTO updateAreaDetails(RequestAreaDTO requestAreaDTO,int id) {
        if(areaRepository.existsById(id)){
                AreaEntity referenceByIdEntity  = areaRepository.getReferenceById(id);
                modelMapper.map(requestAreaDTO,referenceByIdEntity);
                AreaEntity savedEntity = areaRepository.save(referenceByIdEntity);
                return modelMapper.map(savedEntity,ResponseAreaDTO.class);
            }else {
                throw new NotFoundException("Area is not found");
            }
    }
    @Override
    public String deleteArea(int id) {
        if(areaRepository.existsById(id)){
            AreaEntity referenceById = areaRepository.getReferenceById(id);
            areaRepository.delete(referenceById);
            return " deleted";
        }else{
            throw new NotFoundException("Area is not found");
        }
    }
}
