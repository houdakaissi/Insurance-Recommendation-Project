package com.example.recom_ml_models.controllers.userTravel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserTravelSimplifiedPredictionRequest {


    private int duration;
    private float startFranchise;
    private float endFranchise;

}
