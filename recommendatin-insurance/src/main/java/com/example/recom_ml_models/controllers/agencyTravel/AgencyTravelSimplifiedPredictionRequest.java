package com.example.recom_ml_models.controllers.agencyTravel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AgencyTravelSimplifiedPredictionRequest {


    private int duration;
    private float startFranchise;
    private float endFranchise;

}
