package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.repositories.UsuarioRepository;
import com.example.Reto.models.Usuario;
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

	 @Autowired
	    private UsuarioRepository repository;

	    @GetMapping("/todos")
	    public List<Usuario> getUsuarios(){
	        return repository.findAll();
	    }

	    @PostMapping("/login")
	    public Object login(@RequestBody Usuario usuario){
	    	return repository.findByUsuario(usuario.getUsuario());
	    }

}
