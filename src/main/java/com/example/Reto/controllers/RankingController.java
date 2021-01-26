package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.models.Ranking;
import com.example.Reto.models.Usuario;
import com.example.Reto.repositories.RankingRepository;
@RequestMapping("/ranking")
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RankingController {

	@Autowired
	private RankingRepository repository;

	@Autowired
    protected MongoTemplate mongoTemplate;

	@GetMapping("/all")
	public List<Ranking> getEanking(){
		return repository.findAll();
	}

	@PostMapping("/nuevo")
	  public void insertarRanking(@RequestBody Ranking ranking) {
		repository.save(ranking);
	  }

	@PutMapping("/actualizar")
	  public void actualizarRanking(@RequestBody Ranking ranking) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(ranking.get_id()));
		Ranking ranking1 = mongoTemplate.findOne(query, Ranking.class);
		ranking1.set_id(ranking.get_id());
		repository.save(ranking);
 }

	@GetMapping("/{rutasId}")
	public List<Ranking> getPreguntaRuta(@PathVariable String rutasId){
		return repository.findByRutasIdOrderByPuntosDesc(rutasId);
	}
}
