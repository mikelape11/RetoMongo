package com.example.Reto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Rutas;

public interface RutasRepository extends MongoRepository<Rutas, String> {
	Optional<Rutas> findBy_id(String id);
	List<Rutas> findByCiudad(String ciudad);
}
