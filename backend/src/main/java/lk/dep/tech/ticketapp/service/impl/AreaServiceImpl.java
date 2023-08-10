package lk.dep.tech.ticketapp.service.impl;

import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.entity.AreaEntity;
import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.exception.DuplicateEntryException;
import lk.dep.tech.ticketapp.exception.NotFoundException;
import lk.dep.tech.ticketapp.repo.AreaRepository;
import lk.dep.tech.ticketapp.service.AreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveDetails(AreaDTO areaDTO) {
        AreaEntity areaEntity = modelMapper.map(areaDTO, AreaEntity.class);

        if(areaRepository.existsById(areaEntity.getArea())){
            throw new  DuplicateEntryException("The Area is already Exist");
        }
        areaRepository.save(areaEntity);
        return "successfully saved";
    }

    @Override
    public AreaDTO updateAreaDetails(AreaDTO areaDTO, Area area) {
            if(areaRepository.existsById(area)){
                AreaEntity referenceByIdEntity  = areaRepository.getReferenceById(area);
                modelMapper.map(areaDTO,referenceByIdEntity);
                AreaEntity savedEntity = areaRepository.save(referenceByIdEntity);
                return modelMapper.map(savedEntity, AreaDTO.class);
            }else {
                throw new NotFoundException("Area is not found");
            }
    }

    @Override
    public String deleteArea(Area area) {
        if(areaRepository.existsById(area)){
            AreaEntity referenceById = areaRepository.getReferenceById(area);
            areaRepository.delete(referenceById);
            return " deleted";
        }else{
            throw new NotFoundException("Area is not found");
        }
    }
}
