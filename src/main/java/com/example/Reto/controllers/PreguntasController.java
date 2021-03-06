package com.example.Reto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.models.Preguntas;
import com.example.Reto.models.PreguntasRespuestas;
import com.example.Reto.models.Rutas;
import com.example.Reto.repositories.PreguntasRepository;

@RequestMapping("/preguntas")
@RestController
@CrossOrigin(origins="*")
public class PreguntasController {
	@Autowired
	private PreguntasRepository repository;

	@GetMapping("/all")//Funcion para recoger todas las preguntas en la base de datos
	public List<Preguntas> getPreguntas(){
		return repository.findAll();
	}
	@GetMapping("/{rutasId}")//Coger las preguntas según su ruta
	public List<Preguntas> getPreguntaRuta(@PathVariable String rutasId){
		return repository.findByRutasIdOrderByNumPregunta(rutasId);
	}

	@DeleteMapping("/{rutasId}")//Borrar las preguntas según su ruta
	public void deletePreguntaRuta(@PathVariable String rutasId){
		List<Preguntas> preguntas = repository.findByRutasId(rutasId);
		repository.deleteAll(preguntas);
	}
	@PostMapping("/guardar")//Funcion para guardar una pregunta en una ruta
	public void savePregunta(@RequestBody Preguntas preguntas){
		repository.save(preguntas);
	}
	@PutMapping("/{id}")//Funcion para actualizar las preguntas de una ruta
	public Preguntas actPreguntas(@RequestBody Preguntas pregunta, @PathVariable String id){
		Preguntas preg = repository.findBy_id(id);
		preg.setPregunta(pregunta.getPregunta());
		preg.setOpcion(pregunta.getOpcion());
		preg.setRespuestas(pregunta.getRespuestas());

		return repository.save(preg);
	}
}