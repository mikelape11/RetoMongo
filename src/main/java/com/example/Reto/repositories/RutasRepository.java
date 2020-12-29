package com.example.Reto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Rutas;

public interface RutasRepository extends MongoRepository<Rutas, String> {

}
