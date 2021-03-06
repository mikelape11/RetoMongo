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

	 @GetMapping("/{rutaId}")//Funcion para recoger todas las ubicaciones de los usuarios que estén en x ruta
	    public List<Ubicacion> getUbicacion(String rutaId){
	        return repository.findByRutaId(rutaId);
	    }

	@PostMapping("/nuevo")//Funcion para que un usuario inserte su ubicación al entrar a la ruta
	  public void insertarUbicacion(@RequestBody Ubicacion ubicacion) {
		repository.save(ubicacion);
	  }


	 @PutMapping("/actualizar")//Funcion la cual irá actualizando la posicion del usuario
		public void actualizarUbicacion(@RequestBody Ubicacion ubicacion) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(ubicacion.get_id()));
	    	 Ubicacion ubicacion1 = mongoTemplate.findOne(query, Ubicacion.class);
	    	 ubicacion1.set_id(ubicacion.get_id());
	    	 repository.save(ubicacion);
	    }

	  @DeleteMapping("/eliminarPorNombre/{nombreUsuario}")//Funcion que borrará la ubicación del usuario al salir
	  public void deleteUbicacion(@PathVariable String nombreUsuario) {
	    repository.deleteBynombreUsuario(nombreUsuario);
	  }



}
