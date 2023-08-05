package lk.dep.tech.ticketapp.controller;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.service.CheckInService;
import lk.dep.tech.ticketapp.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/checkin")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @PostMapping("/saveall")
    public ResponseEntity<StandardResponse> saveVehicles(@RequestBody RequestDTO requestDTO) {
        String message = checkInService.saveAll(requestDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "success", message), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<StandardResponse> getAllVeicles() {
        List<CheckInDTO> allVehicles = checkInService.getAllVehicles();
        return new ResponseEntity<>(new StandardResponse(200,"Success",allVehicles),HttpStatus.OK);
    }

    @GetMapping("getvehicle")
    public ResponseEntity<StandardResponse> getaVehicle(
         @RequestParam(value = "id",required = false) int id,
         @RequestParam(value = "date",required = false) String date,
         @RequestParam(value = "time",required = false) String time,
         @RequestParam(value = "regNumber",required = false) String regNumber,
         @RequestParam (value = "category",required = false) String vehicleType  ){

        List<RequestDTO> requestDTO = checkInService.getVehicleBySearch(id,date,time,regNumber,vehicleType);
        if(requestDTO.isEmpty()){
            return new ResponseEntity<>(new StandardResponse(404,"Failed","No such Content"),HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(new StandardResponse(200,"Success",requestDTO),HttpStatus.OK);
        }

    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<StandardResponse> deleteVeicle(@PathVariable(value = "id") int vehicleId) {
        String message = checkInService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(new StandardResponse(204,"Deleted",message),HttpStatus.NO_CONTENT);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<StandardResponse> updateVEhicleDetails(@RequestBody RequestDTO requestDTO, @PathVariable(value = "id") int vehicleId) {
        CheckInDTO checkInDTO1 = checkInService.updateVehicle(requestDTO, vehicleId);
        return new ResponseEntity<>(new StandardResponse(204,"updated",checkInDTO1),HttpStatus.NO_CONTENT);
    }
}
