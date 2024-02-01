package com.example.recom_ml_models.repositories;


import com.example.recom_ml_models.entities.Car;
import com.example.recom_ml_models.entities.Internship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipRepository extends MongoRepository<Internship, String> {
    List<Internship> findFirst10ByOrderByClusterAsc();
    @Query("{ 'cluster' : ?0 }")
    List<Internship> findByCluster(int cluster);
    @Query("{'agency': ?0 }")
    List<Internship> getInternshipsByAgency(String agency);

}