package com.example.recom_ml_models.controllers.userCar;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserCarPredictionRequest {

    private float mileage;
    private int age;

}
