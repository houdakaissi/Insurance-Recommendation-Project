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
@Document(collection = "travel")
public class Travel {
    @Id
    private String id;
    private String agency;
    private String destination;
    private int duration;
    private float franchise;
    private int max_compensation;
    private String address;
    private String location;
    private String phoneNumber;
    private int cluster;
}
