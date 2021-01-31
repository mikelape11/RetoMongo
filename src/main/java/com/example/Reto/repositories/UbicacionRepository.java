package com.example.Reto.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Ubicacion;

public interface UbicacionRepository extends MongoRepository<Ubicacion, String>{


	void deleteBynombreUsuario(String nombreUsuario);
	List<Ubicacion> findByRutaId(String rutaId);

}
