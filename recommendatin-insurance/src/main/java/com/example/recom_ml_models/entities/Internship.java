package com.example.recom_ml_models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "internship")
public class Internship {

    @Id
    private String id;
    private String agency;
    private float duration;
    private float franchise;
    private float max_compensation;
    private String address;
    private String location;
    private String phoneNumber;
    private int cluster;
}
