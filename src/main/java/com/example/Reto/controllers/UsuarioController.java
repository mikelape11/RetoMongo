package com.example.Reto.controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="http://localhost:3000")//IMPORTANTE!!!!!!!!
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
//	    	System.out.println(user.getPassword());
//	    	System.out.println(usuario.getPassword());
//	    	System.out.println(user.getId());
	    	JSONObject json = new JSONObject();
	    	json.put("usuario", user.getUsuario());
	    	
	    	if(usuario.getPassword().equals(user.getPassword())){//El error 500 que da es en esta línea, a ver si veis porque e
	    		json.put("status", 200);
	    		return json;
	    	}else{
	    		json.put("error", 404);
	    		return json;
	    	}//Esto es temporal, pero de momento no tira. Javi
	    }

}
