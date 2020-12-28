package com.example.Reto.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Reto.models.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, String>{

	Object findByUsuario(String usuario);




}
