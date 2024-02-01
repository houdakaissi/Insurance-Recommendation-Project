package com.example.recom_ml_models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "car")
public class Car {
    @Id
    private String id;
    private String agency; // Note the capitalization
    private int age; // Note the capitalization
    private float mileage; // Note the capitalization
    private float premium; // Note the capitalization
    private int max_compensation; // Note the capitalization
    private String address; // Note the capitalization
    private String location; // Note the capitalization
    private String phoneNumber; // Note the capitalization
    private int cluster;


}

