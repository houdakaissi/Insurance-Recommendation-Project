package com.example.recom_ml_models.services;



import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.entities.Internship;

import java.util.List;

public interface InternshipService {
    List<Internship> getFirst10Internships();
    List<Internship> getAllInternships();
    List<Internship> getInternshipsByCluster(int cluster);
    void addInternship(Internship internship);
    List<Internship> getInternshipsByAgency(String agency);
}

