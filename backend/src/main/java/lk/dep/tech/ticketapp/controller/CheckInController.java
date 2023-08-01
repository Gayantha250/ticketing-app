package lk.dep.tech.ticketapp.controller;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.dto.request.RequestDTO;
import lk.dep.tech.ticketapp.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/checkin")
public class CheckInController {

    @Autowired
    CheckInService checkInService;
    @PostMapping("/saveall")
    public String saveVehicles(@RequestBody RequestDTO requestDTO){

        String message = checkInService.saveAll(requestDTO);
        return message;
    }
    @GetMapping("/getall")
    public List<CheckInDTO> getAllVeicles(){
        List<CheckInDTO> allVehicles = checkInService.getAllVehicles();
        return allVehicles;
    }

    @GetMapping("getvehicle/{id}")
    public CheckInDTO getaVehicle(@PathVariable(value = "id") int vehicleId){

         CheckInDTO checkInDTO =checkInService.getVehicleById(vehicleId);
        return checkInDTO;
    }

    @DeleteMapping("delete/{id}")
    public String deleteVeicle(@PathVariable(value = "id") int vehicleId){
        String message = checkInService.deleteVehicle(vehicleId);
        return message;
    }

    @PatchMapping("update/{id}")
    public CheckInDTO updateVEhicleDetails(@RequestBody RequestDTO requestDTO ,@PathVariable(value = "id") int vehicleId){
        CheckInDTO checkInDTO1 = checkInService.updateVehicle(requestDTO, vehicleId);
        return checkInDTO1;
    }
}
