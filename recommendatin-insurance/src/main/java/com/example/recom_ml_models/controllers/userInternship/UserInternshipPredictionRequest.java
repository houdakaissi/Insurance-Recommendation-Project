package com.example.recom_ml_models.controllers.userInternship;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserInternshipPredictionRequest {

    private int duration;
    private float startFranchise;
    private float endFranchise;

}
