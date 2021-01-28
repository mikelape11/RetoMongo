package com.example.Reto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Ubicacion;

public interface UbicacionRepository extends MongoRepository<Ubicacion, String>{


	void deleteBynombreUsuario(String nombreUsuario);


}
