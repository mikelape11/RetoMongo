package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.models.Preguntas;
import com.example.Reto.models.Ranking;
import com.example.Reto.repositories.RankingRepository;

@RequestMapping("/ranking")
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RankingController {

	@Autowired
	private RankingRepository repository;

	@GetMapping("/all")
	public List<Ranking> getEanking(){
		return repository.findAll();
	}

	@GetMapping("/{rutasId}")
	public List<Ranking> getPreguntaRuta(@PathVariable String rutasId){
		return repository.findByRutasIdOrderByPuntosDesc(rutasId);
	}
}
