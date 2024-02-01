package com.example.recom_ml_models.services;

import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getFirst10Cars() {
        return carRepository.findFirst10ByOrderByClusterAsc();
    }
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByCluster(int cluster) {
        return carRepository.findByCluster(cluster);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getCarsByAgency(String agency){return carRepository.findCarsByAgency(agency);}
}

