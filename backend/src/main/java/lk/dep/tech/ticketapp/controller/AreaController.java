package lk.dep.tech.ticketapp.controller;


import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.dto.request.RequestAreaDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseAreaCapacityDTO;
import lk.dep.tech.ticketapp.dto.response.ResponseAreaDTO;
import lk.dep.tech.ticketapp.service.AreaService;
import lk.dep.tech.ticketapp.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    @PostMapping("/savearea")
    public ResponseEntity<StandardResponse> saveAreaDetails(@RequestBody AreaDTO areaDTO) {
        String message = areaService.saveDetails(areaDTO);
        return new ResponseEntity<>(new StandardResponse(201, "Success", message), HttpStatus.CREATED);

    }

    @PatchMapping("/updateArea/{id}")
    public ResponseEntity<StandardResponse> updateAreaDetails(@RequestBody RequestAreaDTO requestAreaDTO, @PathVariable(value = "id") int id) {
        ResponseAreaDTO responseAreaDTO1 = areaService.updateAreaDetails(requestAreaDTO, id);
        return new ResponseEntity<>(new StandardResponse(204, "updated", responseAreaDTO1), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updatecapacity/{id}")
    public ResponseEntity<StandardResponse> updateCapasityDetails(@RequestBody AreaDTO areaDTO, @PathVariable(value = "id") int areaId ){
        ResponseAreaCapacityDTO responseAreaCapacityDTO = areaService.updateAreaCapacityDetails(areaDTO, areaId);
        return  new ResponseEntity<>(new StandardResponse(204,"updated",responseAreaCapacityDTO),HttpStatus.OK);

    }

    @DeleteMapping("/deletearea/{id}")
    public ResponseEntity<StandardResponse> deleteAreaDetails(@PathVariable(value = "id") int id) {
        String message = areaService.deleteArea(id);
        return new ResponseEntity<>(new StandardResponse(204,"deleted",message),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getall")
    public ResponseEntity<StandardResponse> getAllAreas(){
        List<ResponseAreaDTO> allAreaDTOSList = areaService.getAllArea();
        return new ResponseEntity<>(new StandardResponse(200,"success",allAreaDTOSList),HttpStatus.OK);
    }
    @GetMapping("/getAreaCapacity")
    public ResponseEntity<StandardResponse> getAreas(){
        List<ResponseAreaCapacityDTO> responseAreaCapacityDTOList = areaService.getonlyAreaAndCapacity();
        return new ResponseEntity<>(new StandardResponse(200,"Success",responseAreaCapacityDTOList),HttpStatus.OK);
    }
}
