package com.example.recom_ml_models.repositories;


import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.entities.Internship;
import com.example.recom_ml_models.entities.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends MongoRepository<Travel, String> {
    List<Travel> findFirst10ByOrderByClusterAsc();
    @Query("{ 'cluster' : ?0 }")
    List<Travel> findByCluster(int cluster);

    @Query("{'agency': ?0 }")
    List<Travel> findTravelByAgency(String agency);

    List<Travel> findByDestination(String destination);

}
