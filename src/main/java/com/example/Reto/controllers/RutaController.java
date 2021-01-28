package com.example.Reto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.repositories.RutasRepository;
import com.example.Reto.models.Rutas;

@RequestMapping("/routes")
@RestController
@CrossOrigin(origins="*")//IMPORTANTE!!!!!!!
public class RutaController {
	@Autowired
		private RutasRepository repository;

		@GetMapping("/all")
		public List<Rutas> getRutas(){
			return repository.findAll();
		}

		@GetMapping("/{id}")
		public Optional<Rutas> getRuta(@PathVariable String id){
			return repository.findBy_id(id);
		}
		@DeleteMapping("/{id}")
	    public void borrarRuta(@PathVariable String id){
	    	repository.deleteById(id);
	    }
		@GetMapping("/ciudad/{ciudad}")
		public List<Rutas> getRutaCiudad(@PathVariable String ciudad){
			return repository.findByCiudad(ciudad);
		}
		@PostMapping("/save")
		public Optional<Rutas> saveRuta(@RequestBody Rutas ruta){
			repository.save(ruta);
			Optional<Rutas> ruta2 = repository.findBy_id(ruta.get_id());
			return ruta2;
		}
}
//https://www.baeldung.com/spring-boot-mongodb-upload-file para poner fotos