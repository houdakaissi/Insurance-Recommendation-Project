package com.example.recom_ml_models.repositories;




import com.example.recom_ml_models.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findFirst10ByOrderByClusterAsc();
    @Query("{ 'cluster' : ?0 }")
    List<Car> findByCluster(int cluster);

    @Query("{'agency': ?0 }")
    List<Car> findCarsByAgency(String agency);
}

