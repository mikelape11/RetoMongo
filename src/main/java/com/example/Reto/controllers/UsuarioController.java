package com.example.Reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	    @ResponseStatus(HttpStatus.OK)
	    public Object login(@RequestBody Usuario usuario){
	    	//Falta comprobar si el usuario existe. Javi
	    	Usuario user = (Usuario) repository.findByUsuario(usuario.getUsuario());
	    	if(usuario.getPassword().equals(user.getPassword())){
	    		return usuario;
	    	}else{
	    		return false;
	    	}//Esto es temporal, pero de momento no tira. Javi
	    }

}
