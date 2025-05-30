package com.generation.golady.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.golady.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsuario(String usuario);
	
}
