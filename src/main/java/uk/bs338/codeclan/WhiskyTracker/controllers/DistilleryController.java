package uk.bs338.codeclan.WhiskyTracker.controllers;

import org.springframework.web.bind.annotation.ResponseStatus;
import uk.bs338.codeclan.WhiskyTracker.models.Distillery;
import uk.bs338.codeclan.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleries(
            @RequestParam(name = "region", required = false) String region
    ){
        if(region != null){
            return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/distilleries/having")
    @ResponseStatus(HttpStatus.OK)
    public List<Distillery> getByWhiskyHaving(
            @RequestParam(name = "age") int age
    ) {
        return distilleryRepository.findByWhiskiesAge(age);
    }

}
