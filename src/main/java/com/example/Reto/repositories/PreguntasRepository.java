package com.example.Reto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Preguntas;
import com.example.Reto.models.Rutas;

public interface PreguntasRepository extends MongoRepository<Preguntas, String> {

	List<Preguntas> findAll();
	List<Preguntas> findByRutasId(String rutasId);
	List<Preguntas> findByRutasIdOrderByNumPregunta(String rutasId);

}
