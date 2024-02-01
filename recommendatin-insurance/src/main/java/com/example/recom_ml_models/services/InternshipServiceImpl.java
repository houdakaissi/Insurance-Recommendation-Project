package com.example.recom_ml_models.services;


import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    @Override
    public List<Internship> getFirst10Internships() {
        return internshipRepository.findFirst10ByOrderByClusterAsc();
    }

    @Override
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    @Override
    public List<Internship> getInternshipsByCluster(int cluster) {
        return internshipRepository.findByCluster(cluster);
    }

    @Override
    public void addInternship(Internship internship) {
        internshipRepository.save(internship);
    }

    @Override
    public List<Internship> getInternshipsByAgency(String agency) {
        return internshipRepository.getInternshipsByAgency(agency);
    }
}

