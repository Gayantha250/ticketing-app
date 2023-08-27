package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.dto.request.RequestAreaDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseAreaCapacityDTO;
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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public List<ResponseAreaDTO> getAllArea() {
        List<AreaEntity> allAreaEntityList = areaRepository.findAll();
        if(allAreaEntityList.size()>0){
            List<ResponseAreaDTO> responseAreaDTOList= modelMapper.map(allAreaEntityList, new TypeToken<List<ResponseAreaDTO>>() {
            }.getType());
            return responseAreaDTOList;
        }else {
            throw new NotFoundException("No data to retriew");
        }
    }
    @Override
    public List<ResponseAreaCapacityDTO> getonlyAreaAndCapacity() {
        List<AreaEntity> newList=new ArrayList<>();
        List<AreaEntity> allEntities = areaRepository.findAll();
    if(allEntities.size()>0){
        for (AreaEntity allEntity : allEntities) {
            AreaEntity areaEntity = new AreaEntity(allEntity.getId(), allEntity.getArea(), allEntity.getCapacity());
            newList.add(allEntity);
        }
       List<ResponseAreaCapacityDTO> responseAreaCapacityDTOList = modelMapper.map(newList, new TypeToken<List<ResponseAreaCapacityDTO>>() {
        }.getType());
        return responseAreaCapacityDTOList;
    }else {
        throw new NotFoundException("Please Enter the Area");
    }
    }

    @Override
    public ResponseAreaCapacityDTO updateAreaCapacityDetails(AreaDTO areaDTO, int areaId) {
        if(areaRepository.existsById(areaId)){
            AreaEntity referenceByIdEntity = areaRepository.getReferenceById(areaId);
            if(!areaDTO.getArea().equals(referenceByIdEntity.getArea())){
                referenceByIdEntity.setCapacity(areaDTO.getCapacity());
                areaRepository.save(referenceByIdEntity);
              return modelMapper.map(referenceByIdEntity,ResponseAreaCapacityDTO.class);
            }else {
                throw new RuntimeException("Can not change the Area type");
            }
        } else {
            throw  new NotFoundException("No such Area Found");
        }
    }
}
