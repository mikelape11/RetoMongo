package com.example.Reto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Ranking;
import com.example.Reto.models.Rutas;

public interface RankingRepository extends MongoRepository<Ranking, String>{

}
