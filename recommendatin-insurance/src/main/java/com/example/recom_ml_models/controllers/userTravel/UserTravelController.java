package com.example.recom_ml_models.controllers.userTravel;

import com.example.recom_ml_models.entities.Travel;
import com.example.recom_ml_models.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserTravelController {

    @Autowired
    private TravelService travelService;


    @GetMapping("/user_travel_predict/{duration}/{startFranchise}/{endFranchise}/{destination}")
    public List<Travel> predict(
            @PathVariable int duration,
            @PathVariable float startFranchise,
            @PathVariable float endFranchise,
            @PathVariable String destination
    ) {
        // Create a UserCarPredictionRequest and set its attributes based on query parameters
        UserTravelSimplifiedPredictionRequest request = new UserTravelSimplifiedPredictionRequest();
        request.setDuration(duration);
        request.setStartFranchise(startFranchise);
        request.setEndFranchise(endFranchise);


        // Define the ML model endpoint
        //String mlModelUrl = "http://localhost:5002/travel_cluster";
        String mlModelUrl = "http://10.101.238.9:5002/travel_cluster";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and request body
        HttpEntity<UserTravelSimplifiedPredictionRequest> httpEntity = new HttpEntity<>(request, headers);

        // Make a POST request to the ML model
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(mlModelUrl, httpEntity, Integer.class);

        // Get the predictions from the response
        Integer prediction = responseEntity.getBody();
        assert prediction != null;

        // Create a list to store the travels for the predicted clusters and destinations
        List<Travel> recommendedTravels = new ArrayList<>();


        List<Travel> travelsForCluster = travelService.getTravelsByCluster(prediction);

            // Loop over the travels for the cluster and get travels by destination
        for (Travel travel : travelsForCluster) {
                if (travel.getDestination().equalsIgnoreCase(destination)) {
                    recommendedTravels.add(travel);
                }
            }


        // Return the list of recommended travels
        return recommendedTravels;
    }

}

