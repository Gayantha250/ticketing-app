package lk.dep.tech.ticketapp.controller;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
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
    public String saveVehicles(@RequestBody CheckInDTO checkInDTO){

        String message = checkInService.saveAll(checkInDTO);
        return message;
    }
    @GetMapping("/getall")
    public List<CheckInDTO> getAllVeicles(){
        List<CheckInDTO> allVehicles = checkInService.getAllVehicles();
        return allVehicles;
    }


}
