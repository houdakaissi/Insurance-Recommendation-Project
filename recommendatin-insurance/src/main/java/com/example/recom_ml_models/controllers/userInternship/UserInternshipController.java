package com.example.recom_ml_models.controllers.userInternship;


import com.example.recom_ml_models.controllers.userCar.UserCarPredictionRequest;
import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.services.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class UserInternshipController {

    @Autowired
    private InternshipService internshipService;


    @GetMapping("/user_internship_predict/{duration}/{startFranchise}/{endFranchise}")
    public List<Internship> predict(
            @PathVariable int duration,
            @PathVariable float startFranchise,
            @PathVariable float endFranchise
    ) {
        UserInternshipPredictionRequest request = new UserInternshipPredictionRequest();
        request.setDuration(duration);
        request.setStartFranchise(startFranchise);
        request.setEndFranchise(endFranchise);

        // Define the ML model endpoint
        //String mlModelUrl = "http://localhost:5003/internship_cluster";
        String mlModelUrl = "http://10.108.87.19:5003/internship_cluster";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Prepare the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and request body
        HttpEntity<UserInternshipPredictionRequest> httpEntity = new HttpEntity<>(request, headers);

        // Make a POST request to the ML model
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(mlModelUrl, httpEntity, Integer.class);

        Integer predictedCluster = responseEntity.getBody();
        assert predictedCluster != null;

        // Use the predicted cluster to get the list of cars
        List<Internship> internshipsForCluster = internshipService.getInternshipsByCluster(predictedCluster);

        // Return the list of cars for the predicted cluster
        return internshipsForCluster;
    }

}
