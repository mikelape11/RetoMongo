package com.example.Reto.controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.repositories.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.Reto.models.Usuario;

@RequestMapping("/usuarios")
@RestController
@CrossOrigin(origins = "*")//IMPORTANTE!!!!!!!!
public class UsuarioController {

	 @Autowired
	    private UsuarioRepository repository;
	 @Autowired
	    protected MongoTemplate mongoTemplate;

	    @GetMapping("/todos")
	    public List<Usuario> getUsuarios(){
	        return repository.findAll();
	    }
	    @GetMapping("/todos_registrados")
	    public List<Usuario> getUsuariosRegistrados(){
	        return repository.findByRol(0);
	    }
	    @DeleteMapping("/{id}")
	    public void borrarUsuario(@PathVariable String id){
	    	repository.deleteById(id);
	    }

	    @PostMapping("/nuevo")
		  public void insertarUsuario(@RequestBody Usuario usuario) {
	    	repository.save(usuario);
		  }

	    @PutMapping("/actualizar")
		public void actualizarUsuario(@RequestBody Usuario usuario) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(usuario.get_id()));
	    	 Usuario userTest1 = mongoTemplate.findOne(query, Usuario.class);
	    	 userTest1.setUsuario(usuario.getUsuario());
	    	 repository.save(usuario);
	    }


	    @PostMapping("/login")
	    @ResponseStatus(HttpStatus.OK)
	    public Object login(@RequestBody Usuario usuario){
	    	//Falta comprobar si el usuario existe. Javi
	    	Usuario user = (Usuario) repository.findByUsuario(usuario.getUsuario());
//	    	System.out.println(user.getPassword());
//	    	System.out.println(usuario.getPassword());
//	    	System.out.println(user.getId());
	    	String token = "";
	    	try {
	    	    Algorithm algorithm = Algorithm.HMAC256("secret");
	    	    token = JWT.create()
	    	        .withIssuer("auth0")
	    	        .sign(algorithm);
	    	    JWTVerifier verifier = JWT.require(algorithm)
	    	    	    .acceptLeeway(454564)   //1 sec for nbf and iat
	    	    	    .acceptExpiresAt(43200)
	    	    	    .build();
	    	} catch (JWTCreationException exception){
	    	    //Invalid Signing configuration / Couldn't convert Claims.
	    	}

	    	JSONObject json = new JSONObject();
	    	json.put("user", user.getUsuario());
	    	json.put("token", token);

	    	if(usuario.getPassword().equals(user.getPassword())){//El error 500 que da es en esta línea, a ver si veis porque e
	    		json.put("status", 200);
	    		return json;
	    	}else{
	    		json.put("error", 404);
	    		return json;
	    	}//Esto es temporal, pero de momento no tira. Javi
	    }

}