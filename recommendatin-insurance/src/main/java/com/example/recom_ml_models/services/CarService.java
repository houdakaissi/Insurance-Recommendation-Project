package com.example.recom_ml_models.services;





import com.example.recom_ml_models.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getFirst10Cars();
    List<Car> getCarsByCluster(int cluster);
    void addCar(Car car);
    List<Car> getAllCars();
    List<Car> getCarsByAgency(String agency);
}

