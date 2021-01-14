package com.example.Reto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, String>{
	Object findByUsuario(String usuario);
	List<Usuario> findByRol(int rol);




}
