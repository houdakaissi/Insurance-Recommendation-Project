package com.example.recom_ml_models.controllers.agencyCar;



import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.services.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AgencyCarController {

    @Autowired
    private CarService carService;

    @PostMapping("/agency_car_predict")
    public void predict(@RequestBody Car request) {

        // Extract the first three attributes from the original PredictionRequest
        int age = request.getAge();
        float mileage = request.getMileage();


        // Create a simplified request object
        AgencyCarSimplifiedPredictionRequest simplifiedRequest = new AgencyCarSimplifiedPredictionRequest();
        simplifiedRequest.setAge(age);
        simplifiedRequest.setMileage(mileage);

        // Define the ML model endpoint
        //String mlModelUrl = "http://localhost:5001/car_cluster";
        String mlModelUrl = "http://10.107.120.66:5001/car_cluster";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and request body
        HttpEntity<AgencyCarSimplifiedPredictionRequest> httpEntity = new HttpEntity<>(simplifiedRequest, headers);

        // Make a POST request to the ML model
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(mlModelUrl, httpEntity, Integer.class);

        // Get the predicted cluster from the response
        Integer predictedCluster = responseEntity.getBody();
        assert predictedCluster != null;

        request.setCluster(predictedCluster);
        System.out.print(predictedCluster);

        // Use the predicted cluster to get the list of cars
        carService.addCar(request);


    }
}

