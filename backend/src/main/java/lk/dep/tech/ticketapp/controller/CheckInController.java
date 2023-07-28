package lk.dep.tech.ticketapp.controller;

import lk.dep.tech.ticketapp.dto.CheckInDTO;
import lk.dep.tech.ticketapp.service.CheckInService;
import lk.dep.tech.ticketapp.service.impl.CheckInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/checkin")
public class CheckInController {

    @Autowired
    CheckInService checkInService;
    @PostMapping("/saveall")
    public String saveVehicles(@RequestBody CheckInDTO checkInDTO){

        checkInService.saveAll(checkInDTO);
        return "ok";
    }
}
