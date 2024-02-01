package com.example.recom_ml_models.controllers.othercontroller;


import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    @GetMapping("/first10")
    public List<Car> getFirst10Cars() {
        return carService.getFirst10Cars();
    }


    @GetMapping("/byCluster/{cluster}")
    public List<Car> getCarsByCluster(@PathVariable int cluster) {
        return carService.getCarsByCluster(cluster);
    }


    @PostMapping("/add")
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping("/agencyCars")
    public List<Car> getCarsByAgency(String agency){
        return  carService.getCarsByAgency(agency);
    }
}

