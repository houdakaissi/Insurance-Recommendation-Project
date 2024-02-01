package com.example.recom_ml_models.controllers.agencyInternship;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AgencyInternshipSimplifiedPredictionRequest {


    private int duration;
    private float startFranchise;
    private float endFranchise;

}
