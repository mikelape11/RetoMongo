package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.repositories.RutasRepository;
import com.example.Reto.models.Rutas;

@RequestMapping("/routes")
@RestController
@CrossOrigin(origins="http://localhost:3000")//IMPORTANTE!!!!!!!
public class RutaController {
	@Autowired
		private RutasRepository repository;
		
		@GetMapping("/all")
		public List<Rutas> getRutas(){
			return repository.findAll();
		}

}
