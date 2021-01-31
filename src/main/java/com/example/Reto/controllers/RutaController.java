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

import com.example.Reto.repositories.RutasRepository;
import com.example.Reto.models.Rutas;

@RequestMapping("/routes")
@RestController
@CrossOrigin(origins="*")//IMPORTANTE!!!!!!!
public class RutaController {
	@Autowired
		private RutasRepository repository;

		@GetMapping("/all")//Funcion para recoger todas las rutas
		public List<Rutas> getRutas(){
			return repository.findAll();
		}

		@GetMapping("/{id}")//Funcion para recoger una ruta en concreto mediante el identificador
		public Rutas getRuta(@PathVariable String id){
			return repository.findBy_id(id);
		}
		@DeleteMapping("/{id}")//Funcion para borrar una ruta en concreto mediante el identificador
	    public void borrarRuta(@PathVariable String id){
	    	repository.deleteById(id);
	    }
		@GetMapping("/ciudad/{ciudad}")//Funcion para recoger todas las rutas que sean de x ciudad
		public List<Rutas> getRutaCiudad(@PathVariable String ciudad){
			return repository.findByCiudad(ciudad);
		}
		@PostMapping("/save")//Funcion para guardar la ruta
		public Rutas saveRuta(@RequestBody Rutas ruta){
			repository.save(ruta);
			Rutas ruta2 = repository.findBy_id(ruta.get_id());
			return ruta2;
		}
		@PutMapping("/update")//Funcion para actualizar los datos de un ruta
		public String updateRuta(@RequestBody Rutas ruta){
			Rutas rutaU = repository.findBy_id(ruta.get_id());
			rutaU.setNombre(ruta.getNombre());
			rutaU.setCiudad(ruta.getCiudad());
			repository.save(rutaU);
			return rutaU.get_id();
		}
}