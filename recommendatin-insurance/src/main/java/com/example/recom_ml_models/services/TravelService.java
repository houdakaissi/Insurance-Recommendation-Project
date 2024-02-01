package com.example.recom_ml_models.services;


import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.entities.Travel;

import java.util.List;

public interface TravelService {
    List<Travel> getFirst10Travels();
    List<Travel> getAllTravels();
    List<Travel> getTravelsByCluster(int cluster);

    List<Travel> getTravelByDestination(String destination);
    void addTravel(Travel travel);
    List<Travel> getTravelsByAgency(String agency);
}
