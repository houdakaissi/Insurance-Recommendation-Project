package com.example.recom_ml_models.controllers.agencyTravel;

import com.example.recom_ml_models.entities.Internship;
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
public class AgencyTravelController {

    @Autowired
    private TravelService travelService;


    @PostMapping("/agency_travel_predict")
    public void predict(@RequestBody Travel request) {

        int duration = request.getDuration();
        float franchise = request.getFranchise();

        // Create a simplified request object
        AgencyTravelSimplifiedPredictionRequest simplifiedRequest = new AgencyTravelSimplifiedPredictionRequest();
        simplifiedRequest.setDuration(duration);
        simplifiedRequest.setStartFranchise(franchise);
        simplifiedRequest.setEndFranchise(franchise);

        // Define the ML model endpoint
        //String mlModelUrl = "http://localhost:5002/travel_cluster";
        String mlModelUrl = "http://10.101.238.9:5002/travel_cluster";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and request body
        HttpEntity<AgencyTravelSimplifiedPredictionRequest> httpEntity = new HttpEntity<>(simplifiedRequest, headers);

        // Make a POST request to the ML model
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(mlModelUrl, httpEntity, Integer.class);

        // Get the predictions from the response
        Integer predictions = responseEntity.getBody();
        assert predictions != null;

        // Convert the array to a list for easy manipulation
        List<Integer> predictionList = Arrays.asList(predictions);

        // Loop over the predictionList and get internships by cluster
        for (Integer cluster : predictionList) {
            request.setCluster(cluster);
            System.out.print(cluster);
        }

        travelService.addTravel(request);
    }
}

