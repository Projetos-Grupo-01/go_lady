package com.generation.golady.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.golady.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	List<Veiculo> findAllByCategoriaContainingIgnoreCase(String categoria);
	
}
