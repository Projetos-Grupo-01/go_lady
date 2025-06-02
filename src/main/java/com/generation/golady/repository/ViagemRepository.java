package com.generation.golady.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.golady.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem,Long> {
	
	List<Viagem> findAllByUsuarioNomeContainingIgnoreCase(String nome);

}
