package com.example.recom_ml_models.services;

import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.entities.Travel;
import com.example.recom_ml_models.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Travel> getFirst10Travels() {
        return travelRepository.findFirst10ByOrderByClusterAsc();
    }

    @Override
    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public List<Travel> getTravelsByCluster(int cluster) {
        return travelRepository.findByCluster(cluster);
    }

    @Override
    public List<Travel> getTravelByDestination(String destination) {
        return travelRepository.findByDestination(destination);
    }

    @Override
    public void addTravel(Travel travel) {
        travelRepository.save(travel);
    }

    @Override
    public List<Travel> getTravelsByAgency(String agency) {
        return travelRepository.findTravelByAgency(agency);
    }
}

