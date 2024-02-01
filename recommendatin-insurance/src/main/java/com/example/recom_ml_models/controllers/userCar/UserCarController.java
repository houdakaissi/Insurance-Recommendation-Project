package com.example.recom_ml_models.controllers.userCar;


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
public class UserCarController {
    @Autowired
    private CarService carService;

    @GetMapping("/user_car_predict/{age}/{mileage}")
    public List<Car> predict(
            @PathVariable int age,
            @PathVariable float mileage
    ) {
        // Create a UserCarPredictionRequest and set its attributes based on query parameters
        UserCarPredictionRequest request = new UserCarPredictionRequest();
        request.setAge(age);
        request.setMileage(mileage);
        // Define the ML model endpoint
       //String mlModelUrl = "http://localhost:5001/car_cluster";
        String mlModelUrl = "http://10.107.120.66:5001/car_cluster";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and request body
        HttpEntity<UserCarPredictionRequest> httpEntity = new HttpEntity<>(request, headers);

        // Make a POST request to the ML model
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(mlModelUrl, httpEntity, Integer.class);

        // Get the predicted cluster from the response
        Integer predictedCluster = responseEntity.getBody();
        assert predictedCluster != null;

        // Use the predicted cluster to get the list of cars
        List<Car> carsForCluster = carService.getCarsByCluster(predictedCluster);

        // Return the list of cars for the predicted cluster
        return carsForCluster;
    }
}

