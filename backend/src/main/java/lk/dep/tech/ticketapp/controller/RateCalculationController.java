package lk.dep.tech.ticketapp.controller;

import lk.dep.tech.ticketapp.dto.HourlyRateDTO;
import lk.dep.tech.ticketapp.dto.request.RequestHourlyRateDTO;
import lk.dep.tech.ticketapp.service.HourlyRateService;
import lk.dep.tech.ticketapp.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rate")
public class RateCalculationController {

    @Autowired
    HourlyRateService hourlyRateService;

    @PostMapping("/saverate")
    public ResponseEntity<StandardResponse> saveRates(@RequestBody RequestHourlyRateDTO requestHourlyRateDTO){
        String message = hourlyRateService.saveAllRates(requestHourlyRateDTO);
        return new ResponseEntity<>(new StandardResponse(201,"success",message), HttpStatus.CREATED);
    }
    @GetMapping("/getrates")
    public ResponseEntity<StandardResponse> getAllRates(){
        List<HourlyRateDTO> hourlyRateDTOS = hourlyRateService.getAllRates();
        return new ResponseEntity<>(new StandardResponse(200,"Success",hourlyRateDTOS),HttpStatus.OK);
    }
    @PatchMapping("/updaterates/{id}")
    public ResponseEntity<StandardResponse> updateRates(@RequestBody RequestHourlyRateDTO requestHourlyRateDTO,@PathVariable(value = "id") int id){
        String message = hourlyRateService.updateRates(requestHourlyRateDTO, id);
        return  new ResponseEntity<>(new StandardResponse(204,"updated",message),HttpStatus.OK);
    }
    @DeleteMapping("/deleterates/{id}")
    public ResponseEntity<StandardResponse> deleteRates(@PathVariable(value = "id") int categoryId){
        String message = hourlyRateService.deleteRate(categoryId);
        return new ResponseEntity<>(new StandardResponse(204,"deleted",message),HttpStatus.NO_CONTENT);
    }
}
