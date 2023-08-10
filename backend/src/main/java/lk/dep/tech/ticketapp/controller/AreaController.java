package lk.dep.tech.ticketapp.controller;


import lk.dep.tech.ticketapp.dto.AreaDTO;
import lk.dep.tech.ticketapp.entity.enums.Area;
import lk.dep.tech.ticketapp.service.AreaService;
import lk.dep.tech.ticketapp.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/updateArea/{area}")
    public ResponseEntity<StandardResponse> updateAreaDetails(@RequestBody AreaDTO areaDTO, @PathVariable(value = "area") Area area) {
        AreaDTO areaDTO1 = areaService.updateAreaDetails(areaDTO, area);
        return new ResponseEntity<>(new StandardResponse(204, "updated", areaDTO1), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deletearea/{area}")
    public ResponseEntity<StandardResponse> deleteAreaDetails(@PathVariable(value = "area") Area area) {
        String message = areaService.deleteArea(area);
        return new ResponseEntity<>(new StandardResponse(204,"deleted",message),HttpStatus.NO_CONTENT);
    }


}
