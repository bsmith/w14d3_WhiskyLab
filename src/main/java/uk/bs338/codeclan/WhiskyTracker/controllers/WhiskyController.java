package uk.bs338.codeclan.WhiskyTracker.controllers;

import org.springframework.web.bind.annotation.ResponseStatus;
import uk.bs338.codeclan.WhiskyTracker.models.Whisky;
import uk.bs338.codeclan.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(
            @RequestParam(name="year", required = false) Integer year
    ){
        if (year !=null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/whiskies/find")
    public ResponseEntity<List<Whisky>> findWhisky(
            @RequestParam(name="distillery", required = true) String name,
            @RequestParam(name = "age", required = true) int age
    ){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/byregion")
    @ResponseStatus(HttpStatus.OK)
    public List<Whisky> findByRegion(
            @RequestParam(name = "region") String region
    ) {
        return whiskyRepository.findByDistilleryRegionIgnoringCase(region);
    }

}
