package com.example.recom_ml_models.controllers.othercontroller;

import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.services.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internships")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @GetMapping("/first10")
    public List<Internship> getFirst10Internships() {
        return internshipService.getFirst10Internships();
    }

    @GetMapping("/all")
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }


    @GetMapping("/byCluster/{cluster}")
    public List<Internship> getInternshipsByCluster(@PathVariable int cluster) {
        return internshipService.getInternshipsByCluster(cluster);
    }



    @PostMapping("/add")
    public void addInternship(@RequestBody Internship internship) {
        internshipService.addInternship(internship);
    }

    @GetMapping("/agencyInternship")
    public List<Internship> getInternshipsByAgency(String agency){
        return  internshipService.getInternshipsByAgency(agency);
    }
}

