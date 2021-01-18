package com.example.Reto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.models.Preguntas;
import com.example.Reto.models.Rutas;
import com.example.Reto.repositories.PreguntasRepository;

@RequestMapping("/preguntas")
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PreguntasController {
	@Autowired
	private PreguntasRepository repository;

	@GetMapping("/all")
	public List<Preguntas> getPreguntas(){
		return repository.findAll();
	}
	@GetMapping("/{rutasId}")
	public List<Preguntas> getPreguntaRuta(@PathVariable String rutasId){
		return repository.findByRutasId(rutasId);
	}
	@PostMapping("/guardar")
	public void savePregunta(@RequestBody Preguntas preguntas){
		repository.save(preguntas);
	}
}