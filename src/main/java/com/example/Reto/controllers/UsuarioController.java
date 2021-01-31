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
	    @GetMapping("/todos_registrados")//Funcion para recoger a los usuarios registrados desde el movil
	    public List<Usuario> getUsuariosRegistrados(){
	        return repository.findByRol(1);
	    }
	    @DeleteMapping("/{id}")//Funcion bara eliminar usuario, ya sea por decision del jugador o del administrador
	    public void borrarUsuario(@PathVariable String id){
	    	repository.deleteById(id);
	    }

	    @PostMapping("/nuevo")//Funcion para que un usuario se registre desde el movil
		  public void insertarUsuario(@RequestBody Usuario usuario) {
	    	repository.save(usuario);
		  }

	    @PutMapping("/actualizar")//Funcion para que un usuario desde el movil actualice sus datos
		public void actualizarUsuario(@RequestBody Usuario usuario) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(usuario.get_id()));
	    	 Usuario userTest1 = mongoTemplate.findOne(query, Usuario.class);
	    	 userTest1.setUsuario(usuario.getUsuario());
	    	 repository.save(usuario);
	    }


	    @PostMapping("/login")//Inicio de sesión de usuario
	    @ResponseStatus(HttpStatus.OK)
	    public Object login(@RequestBody Usuario usuario){
	    	JSONObject json = new JSONObject();//Se crea el objeto json que se enviará para comprobar si ha salido bien el inicio de sesion
	    	Usuario user;
	    	try{
	    		user = (Usuario) repository.findByUsuario(usuario.getUsuario());//Buscamos si el usuario existe
	    	}catch(Exception e){
	    		json.put("error", 404);//Si el usuario no existe se mandará el json con el error
	    		return json;
	    	}

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
	    	}//Funcion para crear un token de verificación

	    	if(usuario.getPassword().equals(user.getPassword())){
	    		json.put("user", user.getUsuario());//Metemos el usuario dentro del json
		    	json.put("token", token);//el token creado
	    		json.put("status", 200);//y el status de exito
	    		return json;
	    	}else{
	    		json.put("error", 404);//si falla la comprobacion de contraseña se enviará el código de error not found
	    		return json;
	    	}
	    }

}