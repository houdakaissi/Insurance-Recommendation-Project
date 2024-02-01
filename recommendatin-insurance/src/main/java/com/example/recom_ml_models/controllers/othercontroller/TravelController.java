package com.example.recom_ml_models.controllers.othercontroller;

import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.entities.Travel;
import com.example.recom_ml_models.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/first10")
    public List<Travel> getFirst10Travels() {
        return travelService.getFirst10Travels();
    }

    @GetMapping("/all")
    public List<Travel> getAllTravels() {
        return travelService.getAllTravels();
    }


    @GetMapping("/byCluster/{cluster}")
    public List<Travel> getTravelsByCluster(@PathVariable int cluster) {
        return travelService.getTravelsByCluster(cluster);
    }



    @GetMapping("/agencyTravel")
    public List<Travel> getTravelsByAgency(String agency){
        return  travelService.getTravelsByAgency(agency);
    }

    @PostMapping("/add")
    public void addTravel(@RequestBody Travel travel) {
        travelService.addTravel(travel);
    }
}

