package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.models.Ubicacion;
import com.example.Reto.repositories.UbicacionRepository;

@RequestMapping("/ubicacion")
@RestController
@CrossOrigin(origins = "*")//
public class UbicacionController {

	 @Autowired
	    private UbicacionRepository repository;

	 @Autowired
	    protected MongoTemplate mongoTemplate;

	 @GetMapping("/todos")
	    public List<Ubicacion> getUbicacion(){
	        return repository.findAll();
	    }

	@PostMapping("/nuevo")
	  public void insertarUbicacion(@RequestBody Ubicacion ubicacion) {
		repository.save(ubicacion);
	  }


	 @PutMapping("/actualizar")
		public void actualizarUbicacion(@RequestBody Ubicacion ubicacion) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(ubicacion.get_id()));
	    	 Ubicacion ubicacion1 = mongoTemplate.findOne(query, Ubicacion.class);
	    	 ubicacion1.set_id(ubicacion.get_id());
	    	 repository.save(ubicacion);
	    }

	  @DeleteMapping("/eliminarPorNombre/{nombreUsuario}")
	  public void deleteUbicacion(@PathVariable String nombreUsuario) {
	    repository.deleteBynombreUsuario(nombreUsuario);
	  }



}
